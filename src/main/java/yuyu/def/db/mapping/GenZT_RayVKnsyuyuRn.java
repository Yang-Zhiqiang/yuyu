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
import yuyu.def.db.entity.ZT_RayVKnsyuyuRn;
import yuyu.def.db.id.PKZT_RayVKnsyuyuRn;
import yuyu.def.db.meta.GenQZT_RayVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RayVKnsyuyuRn;

/**
 * ＲＡＹＶ検証用Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_RayVKnsyuyuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RayVKnsyuyuRn}</td><td colspan="3">ＲＡＹＶ検証用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_RayVKnsyuyuRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin4 zrnsuuriyouyobin4}</td><td>（連携用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv11 zrnyobiv11}</td><td>（連携用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuurisyuruicd zrnsuurisyuruicd}</td><td>（連携用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin6x2 zrnsuuriyouyobin6x2}</td><td>（連携用）数理用予備項目Ｎ６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkuriagekurisagekbn zrnkuriagekurisagekbn}</td><td>（連携用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin6x3 zrnsuuriyouyobin6x3}</td><td>（連携用）数理用予備項目Ｎ６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrkaiyakusjkkktyouseirrt zrnsrkaiyakusjkkktyouseirrt}</td><td>（連携用）数理用解約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrkyksjkkktyouseiriritu zrnsrkyksjkkktyouseiriritu}</td><td>（連携用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseikou zrnmvatyouseikou}</td><td>（連携用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsisuurendourate zrnsisuurendourate}</td><td>（連携用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuukbn zrnsisuukbn}</td><td>（連携用）指数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkimatukawaserate zrnkimatukawaserate}</td><td>（連携用）期末為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkaiyakukoujyoritu zrnkaiyakukoujyoritu}</td><td>（連携用）解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntumitateriritu zrntumitateriritu}</td><td>（連携用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsknnkaisiymd zrnsknnkaisiymd}</td><td>（連携用）責任開始日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouritu zrnrendouritu}</td><td>（連携用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin3 zrnsuuriyouyobin3}</td><td>（連携用）数理用予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseigow zrnmvatyouseigow}</td><td>（連携用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmvakeisanjisknnjynbkn zrnmvakeisanjisknnjynbkn}</td><td>（連携用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkmtsisuurentumitatekn zrnkmtsisuurentumitatekn}</td><td>（連携用）期末指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkmttirttmtttumitatekn zrnkmttirttmtttumitatekn}</td><td>（連携用）期末定率積立部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkmtsisuurentyokugotmttkn zrnkmtsisuurentyokugotmttkn}</td><td>（連携用）期末指数連動部分直後積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymd zrnsisuubbncalckijyunymd}</td><td>（連携用）指数部分計算基準日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekin zrnsisuubbntumitatekin}</td><td>（連携用）指数部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuu zrntoukisisuu}</td><td>（連携用）当期指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymd zrntoukisisuukijyunymd}</td><td>（連携用）当期指数基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuu zrnzenkisisuu}</td><td>（連携用）前期指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymd zrnzenkisisuukijyunymd}</td><td>（連携用）前期指数基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritu zrntmttknzoukaritu}</td><td>（連携用）積立金増加率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikin zrntoukitumimasikin}</td><td>（連携用）当期積増金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx2 zrnsisuubbncalckijyunymdx2}</td><td>（連携用）指数部分計算基準日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx2 zrnsisuubbntumitatekinx2}</td><td>（連携用）指数部分積立金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux2 zrntoukisisuux2}</td><td>（連携用）当期指数＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx2 zrntoukisisuukijyunymdx2}</td><td>（連携用）当期指数基準年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux2 zrnzenkisisuux2}</td><td>（連携用）前期指数＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx2 zrnzenkisisuukijyunymdx2}</td><td>（連携用）前期指数基準年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux2 zrntmttknzoukaritux2}</td><td>（連携用）積立金増加率＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx2 zrntoukitumimasikinx2}</td><td>（連携用）当期積増金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x2 zrnyobiv9x2}</td><td>（連携用）予備項目Ｖ９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx3 zrnsisuubbncalckijyunymdx3}</td><td>（連携用）指数部分計算基準日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx3 zrnsisuubbntumitatekinx3}</td><td>（連携用）指数部分積立金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux3 zrntoukisisuux3}</td><td>（連携用）当期指数＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx3 zrntoukisisuukijyunymdx3}</td><td>（連携用）当期指数基準年月日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux3 zrnzenkisisuux3}</td><td>（連携用）前期指数＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx3 zrnzenkisisuukijyunymdx3}</td><td>（連携用）前期指数基準年月日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux3 zrntmttknzoukaritux3}</td><td>（連携用）積立金増加率＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx3 zrntoukitumimasikinx3}</td><td>（連携用）当期積増金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x3 zrnyobiv9x3}</td><td>（連携用）予備項目Ｖ９＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx4 zrnsisuubbncalckijyunymdx4}</td><td>（連携用）指数部分計算基準日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx4 zrnsisuubbntumitatekinx4}</td><td>（連携用）指数部分積立金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux4 zrntoukisisuux4}</td><td>（連携用）当期指数＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx4 zrntoukisisuukijyunymdx4}</td><td>（連携用）当期指数基準年月日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux4 zrnzenkisisuux4}</td><td>（連携用）前期指数＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx4 zrnzenkisisuukijyunymdx4}</td><td>（連携用）前期指数基準年月日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux4 zrntmttknzoukaritux4}</td><td>（連携用）積立金増加率＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx4 zrntoukitumimasikinx4}</td><td>（連携用）当期積増金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x4 zrnyobiv9x4}</td><td>（連携用）予備項目Ｖ９＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx5 zrnsisuubbncalckijyunymdx5}</td><td>（連携用）指数部分計算基準日＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx5 zrnsisuubbntumitatekinx5}</td><td>（連携用）指数部分積立金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux5 zrntoukisisuux5}</td><td>（連携用）当期指数＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx5 zrntoukisisuukijyunymdx5}</td><td>（連携用）当期指数基準年月日＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux5 zrnzenkisisuux5}</td><td>（連携用）前期指数＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx5 zrnzenkisisuukijyunymdx5}</td><td>（連携用）前期指数基準年月日＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux5 zrntmttknzoukaritux5}</td><td>（連携用）積立金増加率＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx5 zrntoukitumimasikinx5}</td><td>（連携用）当期積増金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x5 zrnyobiv9x5}</td><td>（連携用）予備項目Ｖ９＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx6 zrnsisuubbncalckijyunymdx6}</td><td>（連携用）指数部分計算基準日＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx6 zrnsisuubbntumitatekinx6}</td><td>（連携用）指数部分積立金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux6 zrntoukisisuux6}</td><td>（連携用）当期指数＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx6 zrntoukisisuukijyunymdx6}</td><td>（連携用）当期指数基準年月日＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux6 zrnzenkisisuux6}</td><td>（連携用）前期指数＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx6 zrnzenkisisuukijyunymdx6}</td><td>（連携用）前期指数基準年月日＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux6 zrntmttknzoukaritux6}</td><td>（連携用）積立金増加率＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx6 zrntoukitumimasikinx6}</td><td>（連携用）当期積増金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x6 zrnyobiv9x6}</td><td>（連携用）予備項目Ｖ９＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx7 zrnsisuubbncalckijyunymdx7}</td><td>（連携用）指数部分計算基準日＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx7 zrnsisuubbntumitatekinx7}</td><td>（連携用）指数部分積立金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux7 zrntoukisisuux7}</td><td>（連携用）当期指数＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx7 zrntoukisisuukijyunymdx7}</td><td>（連携用）当期指数基準年月日＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux7 zrnzenkisisuux7}</td><td>（連携用）前期指数＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx7 zrnzenkisisuukijyunymdx7}</td><td>（連携用）前期指数基準年月日＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux7 zrntmttknzoukaritux7}</td><td>（連携用）積立金増加率＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx7 zrntoukitumimasikinx7}</td><td>（連携用）当期積増金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x7 zrnyobiv9x7}</td><td>（連携用）予備項目Ｖ９＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx8 zrnsisuubbncalckijyunymdx8}</td><td>（連携用）指数部分計算基準日＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx8 zrnsisuubbntumitatekinx8}</td><td>（連携用）指数部分積立金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux8 zrntoukisisuux8}</td><td>（連携用）当期指数＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx8 zrntoukisisuukijyunymdx8}</td><td>（連携用）当期指数基準年月日＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux8 zrnzenkisisuux8}</td><td>（連携用）前期指数＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx8 zrnzenkisisuukijyunymdx8}</td><td>（連携用）前期指数基準年月日＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux8 zrntmttknzoukaritux8}</td><td>（連携用）積立金増加率＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx8 zrntoukitumimasikinx8}</td><td>（連携用）当期積増金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x8 zrnyobiv9x8}</td><td>（連携用）予備項目Ｖ９＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx9 zrnsisuubbncalckijyunymdx9}</td><td>（連携用）指数部分計算基準日＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx9 zrnsisuubbntumitatekinx9}</td><td>（連携用）指数部分積立金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux9 zrntoukisisuux9}</td><td>（連携用）当期指数＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx9 zrntoukisisuukijyunymdx9}</td><td>（連携用）当期指数基準年月日＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux9 zrnzenkisisuux9}</td><td>（連携用）前期指数＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx9 zrnzenkisisuukijyunymdx9}</td><td>（連携用）前期指数基準年月日＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux9 zrntmttknzoukaritux9}</td><td>（連携用）積立金増加率＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx9 zrntoukitumimasikinx9}</td><td>（連携用）当期積増金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x9 zrnyobiv9x9}</td><td>（連携用）予備項目Ｖ９＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx10 zrnsisuubbncalckijyunymdx10}</td><td>（連携用）指数部分計算基準日＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx10 zrnsisuubbntumitatekinx10}</td><td>（連携用）指数部分積立金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux10 zrntoukisisuux10}</td><td>（連携用）当期指数＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx10 zrntoukisisuukijyunymdx10}</td><td>（連携用）当期指数基準年月日＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux10 zrnzenkisisuux10}</td><td>（連携用）前期指数＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx10 zrnzenkisisuukijyunymdx10}</td><td>（連携用）前期指数基準年月日＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux10 zrntmttknzoukaritux10}</td><td>（連携用）積立金増加率＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx10 zrntoukitumimasikinx10}</td><td>（連携用）当期積増金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x10 zrnyobiv9x10}</td><td>（連携用）予備項目Ｖ９＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx11 zrnsisuubbncalckijyunymdx11}</td><td>（連携用）指数部分計算基準日＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx11 zrnsisuubbntumitatekinx11}</td><td>（連携用）指数部分積立金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux11 zrntoukisisuux11}</td><td>（連携用）当期指数＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx11 zrntoukisisuukijyunymdx11}</td><td>（連携用）当期指数基準年月日＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux11 zrnzenkisisuux11}</td><td>（連携用）前期指数＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx11 zrnzenkisisuukijyunymdx11}</td><td>（連携用）前期指数基準年月日＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux11 zrntmttknzoukaritux11}</td><td>（連携用）積立金増加率＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx11 zrntoukitumimasikinx11}</td><td>（連携用）当期積増金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x11 zrnyobiv9x11}</td><td>（連携用）予備項目Ｖ９＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx12 zrnsisuubbncalckijyunymdx12}</td><td>（連携用）指数部分計算基準日＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx12 zrnsisuubbntumitatekinx12}</td><td>（連携用）指数部分積立金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux12 zrntoukisisuux12}</td><td>（連携用）当期指数＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx12 zrntoukisisuukijyunymdx12}</td><td>（連携用）当期指数基準年月日＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux12 zrnzenkisisuux12}</td><td>（連携用）前期指数＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx12 zrnzenkisisuukijyunymdx12}</td><td>（連携用）前期指数基準年月日＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux12 zrntmttknzoukaritux12}</td><td>（連携用）積立金増加率＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx12 zrntoukitumimasikinx12}</td><td>（連携用）当期積増金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x12 zrnyobiv9x12}</td><td>（連携用）予備項目Ｖ９＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx13 zrnsisuubbncalckijyunymdx13}</td><td>（連携用）指数部分計算基準日＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx13 zrnsisuubbntumitatekinx13}</td><td>（連携用）指数部分積立金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux13 zrntoukisisuux13}</td><td>（連携用）当期指数＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx13 zrntoukisisuukijyunymdx13}</td><td>（連携用）当期指数基準年月日＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux13 zrnzenkisisuux13}</td><td>（連携用）前期指数＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx13 zrnzenkisisuukijyunymdx13}</td><td>（連携用）前期指数基準年月日＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux13 zrntmttknzoukaritux13}</td><td>（連携用）積立金増加率＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx13 zrntoukitumimasikinx13}</td><td>（連携用）当期積増金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x13 zrnyobiv9x13}</td><td>（連携用）予備項目Ｖ９＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx14 zrnsisuubbncalckijyunymdx14}</td><td>（連携用）指数部分計算基準日＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx14 zrnsisuubbntumitatekinx14}</td><td>（連携用）指数部分積立金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux14 zrntoukisisuux14}</td><td>（連携用）当期指数＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx14 zrntoukisisuukijyunymdx14}</td><td>（連携用）当期指数基準年月日＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux14 zrnzenkisisuux14}</td><td>（連携用）前期指数＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx14 zrnzenkisisuukijyunymdx14}</td><td>（連携用）前期指数基準年月日＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux14 zrntmttknzoukaritux14}</td><td>（連携用）積立金増加率＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx14 zrntoukitumimasikinx14}</td><td>（連携用）当期積増金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x14 zrnyobiv9x14}</td><td>（連携用）予備項目Ｖ９＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbncalckijyunymdx15 zrnsisuubbncalckijyunymdx15}</td><td>（連携用）指数部分計算基準日＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntumitatekinx15 zrnsisuubbntumitatekinx15}</td><td>（連携用）指数部分積立金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukisisuux15 zrntoukisisuux15}</td><td>（連携用）当期指数＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukisisuukijyunymdx15 zrntoukisisuukijyunymdx15}</td><td>（連携用）当期指数基準年月日＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuux15 zrnzenkisisuux15}</td><td>（連携用）前期指数＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzenkisisuukijyunymdx15 zrnzenkisisuukijyunymdx15}</td><td>（連携用）前期指数基準年月日＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritux15 zrntmttknzoukaritux15}</td><td>（連携用）積立金増加率＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntoukitumimasikinx15 zrntoukitumimasikinx15}</td><td>（連携用）当期積増金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x15 zrnyobiv9x15}</td><td>（連携用）予備項目Ｖ９＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymd zrnteiritucalckijyunymd}</td><td>（連携用）定率部分計算基準日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekin zrnteiritutumitatekin}</td><td>（連携用）定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16 zrnyobiv16}</td><td>（連携用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx2 zrnteiritucalckijyunymdx2}</td><td>（連携用）定率部分計算基準日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx2 zrnteiritutumitatekinx2}</td><td>（連携用）定率部分積立金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x2 zrnyobiv16x2}</td><td>（連携用）予備項目Ｖ１６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx3 zrnteiritucalckijyunymdx3}</td><td>（連携用）定率部分計算基準日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx3 zrnteiritutumitatekinx3}</td><td>（連携用）定率部分積立金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x3 zrnyobiv16x3}</td><td>（連携用）予備項目Ｖ１６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx4 zrnteiritucalckijyunymdx4}</td><td>（連携用）定率部分計算基準日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx4 zrnteiritutumitatekinx4}</td><td>（連携用）定率部分積立金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x4 zrnyobiv16x4}</td><td>（連携用）予備項目Ｖ１６＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx5 zrnteiritucalckijyunymdx5}</td><td>（連携用）定率部分計算基準日＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx5 zrnteiritutumitatekinx5}</td><td>（連携用）定率部分積立金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x5 zrnyobiv16x5}</td><td>（連携用）予備項目Ｖ１６＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx6 zrnteiritucalckijyunymdx6}</td><td>（連携用）定率部分計算基準日＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx6 zrnteiritutumitatekinx6}</td><td>（連携用）定率部分積立金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x6 zrnyobiv16x6}</td><td>（連携用）予備項目Ｖ１６＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx7 zrnteiritucalckijyunymdx7}</td><td>（連携用）定率部分計算基準日＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx7 zrnteiritutumitatekinx7}</td><td>（連携用）定率部分積立金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x7 zrnyobiv16x7}</td><td>（連携用）予備項目Ｖ１６＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx8 zrnteiritucalckijyunymdx8}</td><td>（連携用）定率部分計算基準日＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx8 zrnteiritutumitatekinx8}</td><td>（連携用）定率部分積立金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x8 zrnyobiv16x8}</td><td>（連携用）予備項目Ｖ１６＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx9 zrnteiritucalckijyunymdx9}</td><td>（連携用）定率部分計算基準日＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx9 zrnteiritutumitatekinx9}</td><td>（連携用）定率部分積立金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x9 zrnyobiv16x9}</td><td>（連携用）予備項目Ｖ１６＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx10 zrnteiritucalckijyunymdx10}</td><td>（連携用）定率部分計算基準日＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx10 zrnteiritutumitatekinx10}</td><td>（連携用）定率部分積立金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x10 zrnyobiv16x10}</td><td>（連携用）予備項目Ｖ１６＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx11 zrnteiritucalckijyunymdx11}</td><td>（連携用）定率部分計算基準日＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx11 zrnteiritutumitatekinx11}</td><td>（連携用）定率部分積立金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x11 zrnyobiv16x11}</td><td>（連携用）予備項目Ｖ１６＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx12 zrnteiritucalckijyunymdx12}</td><td>（連携用）定率部分計算基準日＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx12 zrnteiritutumitatekinx12}</td><td>（連携用）定率部分積立金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x12 zrnyobiv16x12}</td><td>（連携用）予備項目Ｖ１６＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx13 zrnteiritucalckijyunymdx13}</td><td>（連携用）定率部分計算基準日＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx13 zrnteiritutumitatekinx13}</td><td>（連携用）定率部分積立金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x13 zrnyobiv16x13}</td><td>（連携用）予備項目Ｖ１６＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx14 zrnteiritucalckijyunymdx14}</td><td>（連携用）定率部分計算基準日＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx14 zrnteiritutumitatekinx14}</td><td>（連携用）定率部分積立金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x14 zrnyobiv16x14}</td><td>（連携用）予備項目Ｖ１６＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritucalckijyunymdx15 zrnteiritucalckijyunymdx15}</td><td>（連携用）定率部分計算基準日＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutumitatekinx15 zrnteiritutumitatekinx15}</td><td>（連携用）定率部分積立金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv16x15 zrnyobiv16x15}</td><td>（連携用）予備項目Ｖ１６＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengakujicalckijyunymd zrngengakujicalckijyunymd}</td><td>（連携用）減額時計算基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengakujisisuutmttkn zrngengakujisisuutmttkn}</td><td>（連携用）減額時指数部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngengakujiteiritutmttkn zrngengakujiteiritutmttkn}</td><td>（連携用）減額時定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x9 zrnyobin11x9}</td><td>（連携用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin14 zrnsuuriyouyobin14}</td><td>（連携用）数理用予備項目Ｎ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_RayVKnsyuyuRn
 * @see     PKZT_RayVKnsyuyuRn
 * @see     QZT_RayVKnsyuyuRn
 * @see     GenQZT_RayVKnsyuyuRn
 */
@MappedSuperclass
@Table(name=GenZT_RayVKnsyuyuRn.TABLE_NAME)
@IdClass(value=PKZT_RayVKnsyuyuRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_RayVKnsyuyuRn extends AbstractExDBEntityForZDB<ZT_RayVKnsyuyuRn, PKZT_RayVKnsyuyuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RayVKnsyuyuRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN4        = "zrnsuuriyouyobin4";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV11               = "zrnyobiv11";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSUURISYURUICD         = "zrnsuurisyuruicd";
    public static final String ZRNSUURIYOUYOBIN6X2      = "zrnsuuriyouyobin6x2";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNKURIAGEKURISAGEKBN    = "zrnkuriagekurisagekbn";
    public static final String ZRNSUURIYOUYOBIN6X3      = "zrnsuuriyouyobin6x3";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNSRKAIYAKUSJKKKTYOUSEIRRT = "zrnsrkaiyakusjkkktyouseirrt";
    public static final String ZRNSRKYKSJKKKTYOUSEIRIRITU = "zrnsrkyksjkkktyouseiriritu";
    public static final String ZRNMVATYOUSEIKOU         = "zrnmvatyouseikou";
    public static final String ZRNSISUURENDOURATE       = "zrnsisuurendourate";
    public static final String ZRNSISUUKBN              = "zrnsisuukbn";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKIMATUKAWASERATE      = "zrnkimatukawaserate";
    public static final String ZRNKAIYAKUKOUJYORITU     = "zrnkaiyakukoujyoritu";
    public static final String ZRNTUMITATERIRITU        = "zrntumitateriritu";
    public static final String ZRNSKNNKAISIYMD          = "zrnsknnkaisiymd";
    public static final String ZRNRENDOURITU            = "zrnrendouritu";
    public static final String ZRNSUURIYOUYOBIN3        = "zrnsuuriyouyobin3";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNMVATYOUSEIGOW         = "zrnmvatyouseigow";
    public static final String ZRNMVAKEISANJISKNNJYNBKN = "zrnmvakeisanjisknnjynbkn";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNKMTSISUURENTUMITATEKN = "zrnkmtsisuurentumitatekn";
    public static final String ZRNKMTTIRTTMTTTUMITATEKN = "zrnkmttirttmtttumitatekn";
    public static final String ZRNKMTSISUURENTYOKUGOTMTTKN = "zrnkmtsisuurentyokugotmttkn";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNSISUUBBNCALCKIJYUNYMD = "zrnsisuubbncalckijyunymd";
    public static final String ZRNSISUUBBNTUMITATEKIN   = "zrnsisuubbntumitatekin";
    public static final String ZRNTOUKISISUU            = "zrntoukisisuu";
    public static final String ZRNTOUKISISUUKIJYUNYMD   = "zrntoukisisuukijyunymd";
    public static final String ZRNZENKISISUU            = "zrnzenkisisuu";
    public static final String ZRNZENKISISUUKIJYUNYMD   = "zrnzenkisisuukijyunymd";
    public static final String ZRNTMTTKNZOUKARITU       = "zrntmttknzoukaritu";
    public static final String ZRNTOUKITUMIMASIKIN      = "zrntoukitumimasikin";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX2 = "zrnsisuubbncalckijyunymdx2";
    public static final String ZRNSISUUBBNTUMITATEKINX2 = "zrnsisuubbntumitatekinx2";
    public static final String ZRNTOUKISISUUX2          = "zrntoukisisuux2";
    public static final String ZRNTOUKISISUUKIJYUNYMDX2 = "zrntoukisisuukijyunymdx2";
    public static final String ZRNZENKISISUUX2          = "zrnzenkisisuux2";
    public static final String ZRNZENKISISUUKIJYUNYMDX2 = "zrnzenkisisuukijyunymdx2";
    public static final String ZRNTMTTKNZOUKARITUX2     = "zrntmttknzoukaritux2";
    public static final String ZRNTOUKITUMIMASIKINX2    = "zrntoukitumimasikinx2";
    public static final String ZRNYOBIV9X2              = "zrnyobiv9x2";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX3 = "zrnsisuubbncalckijyunymdx3";
    public static final String ZRNSISUUBBNTUMITATEKINX3 = "zrnsisuubbntumitatekinx3";
    public static final String ZRNTOUKISISUUX3          = "zrntoukisisuux3";
    public static final String ZRNTOUKISISUUKIJYUNYMDX3 = "zrntoukisisuukijyunymdx3";
    public static final String ZRNZENKISISUUX3          = "zrnzenkisisuux3";
    public static final String ZRNZENKISISUUKIJYUNYMDX3 = "zrnzenkisisuukijyunymdx3";
    public static final String ZRNTMTTKNZOUKARITUX3     = "zrntmttknzoukaritux3";
    public static final String ZRNTOUKITUMIMASIKINX3    = "zrntoukitumimasikinx3";
    public static final String ZRNYOBIV9X3              = "zrnyobiv9x3";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX4 = "zrnsisuubbncalckijyunymdx4";
    public static final String ZRNSISUUBBNTUMITATEKINX4 = "zrnsisuubbntumitatekinx4";
    public static final String ZRNTOUKISISUUX4          = "zrntoukisisuux4";
    public static final String ZRNTOUKISISUUKIJYUNYMDX4 = "zrntoukisisuukijyunymdx4";
    public static final String ZRNZENKISISUUX4          = "zrnzenkisisuux4";
    public static final String ZRNZENKISISUUKIJYUNYMDX4 = "zrnzenkisisuukijyunymdx4";
    public static final String ZRNTMTTKNZOUKARITUX4     = "zrntmttknzoukaritux4";
    public static final String ZRNTOUKITUMIMASIKINX4    = "zrntoukitumimasikinx4";
    public static final String ZRNYOBIV9X4              = "zrnyobiv9x4";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX5 = "zrnsisuubbncalckijyunymdx5";
    public static final String ZRNSISUUBBNTUMITATEKINX5 = "zrnsisuubbntumitatekinx5";
    public static final String ZRNTOUKISISUUX5          = "zrntoukisisuux5";
    public static final String ZRNTOUKISISUUKIJYUNYMDX5 = "zrntoukisisuukijyunymdx5";
    public static final String ZRNZENKISISUUX5          = "zrnzenkisisuux5";
    public static final String ZRNZENKISISUUKIJYUNYMDX5 = "zrnzenkisisuukijyunymdx5";
    public static final String ZRNTMTTKNZOUKARITUX5     = "zrntmttknzoukaritux5";
    public static final String ZRNTOUKITUMIMASIKINX5    = "zrntoukitumimasikinx5";
    public static final String ZRNYOBIV9X5              = "zrnyobiv9x5";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX6 = "zrnsisuubbncalckijyunymdx6";
    public static final String ZRNSISUUBBNTUMITATEKINX6 = "zrnsisuubbntumitatekinx6";
    public static final String ZRNTOUKISISUUX6          = "zrntoukisisuux6";
    public static final String ZRNTOUKISISUUKIJYUNYMDX6 = "zrntoukisisuukijyunymdx6";
    public static final String ZRNZENKISISUUX6          = "zrnzenkisisuux6";
    public static final String ZRNZENKISISUUKIJYUNYMDX6 = "zrnzenkisisuukijyunymdx6";
    public static final String ZRNTMTTKNZOUKARITUX6     = "zrntmttknzoukaritux6";
    public static final String ZRNTOUKITUMIMASIKINX6    = "zrntoukitumimasikinx6";
    public static final String ZRNYOBIV9X6              = "zrnyobiv9x6";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX7 = "zrnsisuubbncalckijyunymdx7";
    public static final String ZRNSISUUBBNTUMITATEKINX7 = "zrnsisuubbntumitatekinx7";
    public static final String ZRNTOUKISISUUX7          = "zrntoukisisuux7";
    public static final String ZRNTOUKISISUUKIJYUNYMDX7 = "zrntoukisisuukijyunymdx7";
    public static final String ZRNZENKISISUUX7          = "zrnzenkisisuux7";
    public static final String ZRNZENKISISUUKIJYUNYMDX7 = "zrnzenkisisuukijyunymdx7";
    public static final String ZRNTMTTKNZOUKARITUX7     = "zrntmttknzoukaritux7";
    public static final String ZRNTOUKITUMIMASIKINX7    = "zrntoukitumimasikinx7";
    public static final String ZRNYOBIV9X7              = "zrnyobiv9x7";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX8 = "zrnsisuubbncalckijyunymdx8";
    public static final String ZRNSISUUBBNTUMITATEKINX8 = "zrnsisuubbntumitatekinx8";
    public static final String ZRNTOUKISISUUX8          = "zrntoukisisuux8";
    public static final String ZRNTOUKISISUUKIJYUNYMDX8 = "zrntoukisisuukijyunymdx8";
    public static final String ZRNZENKISISUUX8          = "zrnzenkisisuux8";
    public static final String ZRNZENKISISUUKIJYUNYMDX8 = "zrnzenkisisuukijyunymdx8";
    public static final String ZRNTMTTKNZOUKARITUX8     = "zrntmttknzoukaritux8";
    public static final String ZRNTOUKITUMIMASIKINX8    = "zrntoukitumimasikinx8";
    public static final String ZRNYOBIV9X8              = "zrnyobiv9x8";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX9 = "zrnsisuubbncalckijyunymdx9";
    public static final String ZRNSISUUBBNTUMITATEKINX9 = "zrnsisuubbntumitatekinx9";
    public static final String ZRNTOUKISISUUX9          = "zrntoukisisuux9";
    public static final String ZRNTOUKISISUUKIJYUNYMDX9 = "zrntoukisisuukijyunymdx9";
    public static final String ZRNZENKISISUUX9          = "zrnzenkisisuux9";
    public static final String ZRNZENKISISUUKIJYUNYMDX9 = "zrnzenkisisuukijyunymdx9";
    public static final String ZRNTMTTKNZOUKARITUX9     = "zrntmttknzoukaritux9";
    public static final String ZRNTOUKITUMIMASIKINX9    = "zrntoukitumimasikinx9";
    public static final String ZRNYOBIV9X9              = "zrnyobiv9x9";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX10 = "zrnsisuubbncalckijyunymdx10";
    public static final String ZRNSISUUBBNTUMITATEKINX10 = "zrnsisuubbntumitatekinx10";
    public static final String ZRNTOUKISISUUX10         = "zrntoukisisuux10";
    public static final String ZRNTOUKISISUUKIJYUNYMDX10 = "zrntoukisisuukijyunymdx10";
    public static final String ZRNZENKISISUUX10         = "zrnzenkisisuux10";
    public static final String ZRNZENKISISUUKIJYUNYMDX10 = "zrnzenkisisuukijyunymdx10";
    public static final String ZRNTMTTKNZOUKARITUX10    = "zrntmttknzoukaritux10";
    public static final String ZRNTOUKITUMIMASIKINX10   = "zrntoukitumimasikinx10";
    public static final String ZRNYOBIV9X10             = "zrnyobiv9x10";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX11 = "zrnsisuubbncalckijyunymdx11";
    public static final String ZRNSISUUBBNTUMITATEKINX11 = "zrnsisuubbntumitatekinx11";
    public static final String ZRNTOUKISISUUX11         = "zrntoukisisuux11";
    public static final String ZRNTOUKISISUUKIJYUNYMDX11 = "zrntoukisisuukijyunymdx11";
    public static final String ZRNZENKISISUUX11         = "zrnzenkisisuux11";
    public static final String ZRNZENKISISUUKIJYUNYMDX11 = "zrnzenkisisuukijyunymdx11";
    public static final String ZRNTMTTKNZOUKARITUX11    = "zrntmttknzoukaritux11";
    public static final String ZRNTOUKITUMIMASIKINX11   = "zrntoukitumimasikinx11";
    public static final String ZRNYOBIV9X11             = "zrnyobiv9x11";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX12 = "zrnsisuubbncalckijyunymdx12";
    public static final String ZRNSISUUBBNTUMITATEKINX12 = "zrnsisuubbntumitatekinx12";
    public static final String ZRNTOUKISISUUX12         = "zrntoukisisuux12";
    public static final String ZRNTOUKISISUUKIJYUNYMDX12 = "zrntoukisisuukijyunymdx12";
    public static final String ZRNZENKISISUUX12         = "zrnzenkisisuux12";
    public static final String ZRNZENKISISUUKIJYUNYMDX12 = "zrnzenkisisuukijyunymdx12";
    public static final String ZRNTMTTKNZOUKARITUX12    = "zrntmttknzoukaritux12";
    public static final String ZRNTOUKITUMIMASIKINX12   = "zrntoukitumimasikinx12";
    public static final String ZRNYOBIV9X12             = "zrnyobiv9x12";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX13 = "zrnsisuubbncalckijyunymdx13";
    public static final String ZRNSISUUBBNTUMITATEKINX13 = "zrnsisuubbntumitatekinx13";
    public static final String ZRNTOUKISISUUX13         = "zrntoukisisuux13";
    public static final String ZRNTOUKISISUUKIJYUNYMDX13 = "zrntoukisisuukijyunymdx13";
    public static final String ZRNZENKISISUUX13         = "zrnzenkisisuux13";
    public static final String ZRNZENKISISUUKIJYUNYMDX13 = "zrnzenkisisuukijyunymdx13";
    public static final String ZRNTMTTKNZOUKARITUX13    = "zrntmttknzoukaritux13";
    public static final String ZRNTOUKITUMIMASIKINX13   = "zrntoukitumimasikinx13";
    public static final String ZRNYOBIV9X13             = "zrnyobiv9x13";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX14 = "zrnsisuubbncalckijyunymdx14";
    public static final String ZRNSISUUBBNTUMITATEKINX14 = "zrnsisuubbntumitatekinx14";
    public static final String ZRNTOUKISISUUX14         = "zrntoukisisuux14";
    public static final String ZRNTOUKISISUUKIJYUNYMDX14 = "zrntoukisisuukijyunymdx14";
    public static final String ZRNZENKISISUUX14         = "zrnzenkisisuux14";
    public static final String ZRNZENKISISUUKIJYUNYMDX14 = "zrnzenkisisuukijyunymdx14";
    public static final String ZRNTMTTKNZOUKARITUX14    = "zrntmttknzoukaritux14";
    public static final String ZRNTOUKITUMIMASIKINX14   = "zrntoukitumimasikinx14";
    public static final String ZRNYOBIV9X14             = "zrnyobiv9x14";
    public static final String ZRNSISUUBBNCALCKIJYUNYMDX15 = "zrnsisuubbncalckijyunymdx15";
    public static final String ZRNSISUUBBNTUMITATEKINX15 = "zrnsisuubbntumitatekinx15";
    public static final String ZRNTOUKISISUUX15         = "zrntoukisisuux15";
    public static final String ZRNTOUKISISUUKIJYUNYMDX15 = "zrntoukisisuukijyunymdx15";
    public static final String ZRNZENKISISUUX15         = "zrnzenkisisuux15";
    public static final String ZRNZENKISISUUKIJYUNYMDX15 = "zrnzenkisisuukijyunymdx15";
    public static final String ZRNTMTTKNZOUKARITUX15    = "zrntmttknzoukaritux15";
    public static final String ZRNTOUKITUMIMASIKINX15   = "zrntoukitumimasikinx15";
    public static final String ZRNYOBIV9X15             = "zrnyobiv9x15";
    public static final String ZRNTEIRITUCALCKIJYUNYMD  = "zrnteiritucalckijyunymd";
    public static final String ZRNTEIRITUTUMITATEKIN    = "zrnteiritutumitatekin";
    public static final String ZRNYOBIV16               = "zrnyobiv16";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX2 = "zrnteiritucalckijyunymdx2";
    public static final String ZRNTEIRITUTUMITATEKINX2  = "zrnteiritutumitatekinx2";
    public static final String ZRNYOBIV16X2             = "zrnyobiv16x2";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX3 = "zrnteiritucalckijyunymdx3";
    public static final String ZRNTEIRITUTUMITATEKINX3  = "zrnteiritutumitatekinx3";
    public static final String ZRNYOBIV16X3             = "zrnyobiv16x3";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX4 = "zrnteiritucalckijyunymdx4";
    public static final String ZRNTEIRITUTUMITATEKINX4  = "zrnteiritutumitatekinx4";
    public static final String ZRNYOBIV16X4             = "zrnyobiv16x4";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX5 = "zrnteiritucalckijyunymdx5";
    public static final String ZRNTEIRITUTUMITATEKINX5  = "zrnteiritutumitatekinx5";
    public static final String ZRNYOBIV16X5             = "zrnyobiv16x5";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX6 = "zrnteiritucalckijyunymdx6";
    public static final String ZRNTEIRITUTUMITATEKINX6  = "zrnteiritutumitatekinx6";
    public static final String ZRNYOBIV16X6             = "zrnyobiv16x6";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX7 = "zrnteiritucalckijyunymdx7";
    public static final String ZRNTEIRITUTUMITATEKINX7  = "zrnteiritutumitatekinx7";
    public static final String ZRNYOBIV16X7             = "zrnyobiv16x7";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX8 = "zrnteiritucalckijyunymdx8";
    public static final String ZRNTEIRITUTUMITATEKINX8  = "zrnteiritutumitatekinx8";
    public static final String ZRNYOBIV16X8             = "zrnyobiv16x8";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX9 = "zrnteiritucalckijyunymdx9";
    public static final String ZRNTEIRITUTUMITATEKINX9  = "zrnteiritutumitatekinx9";
    public static final String ZRNYOBIV16X9             = "zrnyobiv16x9";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX10 = "zrnteiritucalckijyunymdx10";
    public static final String ZRNTEIRITUTUMITATEKINX10 = "zrnteiritutumitatekinx10";
    public static final String ZRNYOBIV16X10            = "zrnyobiv16x10";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX11 = "zrnteiritucalckijyunymdx11";
    public static final String ZRNTEIRITUTUMITATEKINX11 = "zrnteiritutumitatekinx11";
    public static final String ZRNYOBIV16X11            = "zrnyobiv16x11";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX12 = "zrnteiritucalckijyunymdx12";
    public static final String ZRNTEIRITUTUMITATEKINX12 = "zrnteiritutumitatekinx12";
    public static final String ZRNYOBIV16X12            = "zrnyobiv16x12";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX13 = "zrnteiritucalckijyunymdx13";
    public static final String ZRNTEIRITUTUMITATEKINX13 = "zrnteiritutumitatekinx13";
    public static final String ZRNYOBIV16X13            = "zrnyobiv16x13";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX14 = "zrnteiritucalckijyunymdx14";
    public static final String ZRNTEIRITUTUMITATEKINX14 = "zrnteiritutumitatekinx14";
    public static final String ZRNYOBIV16X14            = "zrnyobiv16x14";
    public static final String ZRNTEIRITUCALCKIJYUNYMDX15 = "zrnteiritucalckijyunymdx15";
    public static final String ZRNTEIRITUTUMITATEKINX15 = "zrnteiritutumitatekinx15";
    public static final String ZRNYOBIV16X15            = "zrnyobiv16x15";
    public static final String ZRNGENGAKUJICALCKIJYUNYMD = "zrngengakujicalckijyunymd";
    public static final String ZRNGENGAKUJISISUUTMTTKN  = "zrngengakujisisuutmttkn";
    public static final String ZRNGENGAKUJITEIRITUTMTTKN = "zrngengakujiteiritutmttkn";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNYOBIN11X9             = "zrnyobin11x9";
    public static final String ZRNSUURIYOUYOBIN14       = "zrnsuuriyouyobin14";
    public static final String ZRNYOBIV20               = "zrnyobiv20";

    private final PKZT_RayVKnsyuyuRn primaryKey;

    public GenZT_RayVKnsyuyuRn() {
        primaryKey = new PKZT_RayVKnsyuyuRn();
    }

    public GenZT_RayVKnsyuyuRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_RayVKnsyuyuRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_RayVKnsyuyuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RayVKnsyuyuRn> getMetaClass() {
        return QZT_RayVKnsyuyuRn.class;
    }

    @Id
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSUURIYOUYOBIN4)
    public String getZrnsuuriyouyobin4() {
        return zrnsuuriyouyobin4;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsuuriyouyobin4(String pZrnsuuriyouyobin4) {
        zrnsuuriyouyobin4 = pZrnsuuriyouyobin4;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV11)
    public String getZrnyobiv11() {
        return zrnyobiv11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnyobiv11(String pZrnyobiv11) {
        zrnyobiv11 = pZrnyobiv11;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnsuurisyuruicd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSUURISYURUICD)
    public String getZrnsuurisyuruicd() {
        return zrnsuurisyuruicd;
    }

    public void setZrnsuurisyuruicd(String pZrnsuurisyuruicd) {
        zrnsuurisyuruicd = pZrnsuurisyuruicd;
    }

    private String zrnsuuriyouyobin6x2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSUURIYOUYOBIN6X2)
    public String getZrnsuuriyouyobin6x2() {
        return zrnsuuriyouyobin6x2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsuuriyouyobin6x2(String pZrnsuuriyouyobin6x2) {
        zrnsuuriyouyobin6x2 = pZrnsuuriyouyobin6x2;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnkykymd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnkuriagekurisagekbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKURIAGEKURISAGEKBN)
    public String getZrnkuriagekurisagekbn() {
        return zrnkuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkuriagekurisagekbn(String pZrnkuriagekurisagekbn) {
        zrnkuriagekurisagekbn = pZrnkuriagekurisagekbn;
    }

    private String zrnsuuriyouyobin6x3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSUURIYOUYOBIN6X3)
    public String getZrnsuuriyouyobin6x3() {
        return zrnsuuriyouyobin6x3;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsuuriyouyobin6x3(String pZrnsuuriyouyobin6x3) {
        zrnsuuriyouyobin6x3 = pZrnsuuriyouyobin6x3;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private BizNumber zrnsrkaiyakusjkkktyouseirrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSRKAIYAKUSJKKKTYOUSEIRRT)
    public BizNumber getZrnsrkaiyakusjkkktyouseirrt() {
        return zrnsrkaiyakusjkkktyouseirrt;
    }

    public void setZrnsrkaiyakusjkkktyouseirrt(BizNumber pZrnsrkaiyakusjkkktyouseirrt) {
        zrnsrkaiyakusjkkktyouseirrt = pZrnsrkaiyakusjkkktyouseirrt;
    }

    private BizNumber zrnsrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZrnsrkyksjkkktyouseiriritu() {
        return zrnsrkyksjkkktyouseiriritu;
    }

    public void setZrnsrkyksjkkktyouseiriritu(BizNumber pZrnsrkyksjkkktyouseiriritu) {
        zrnsrkyksjkkktyouseiriritu = pZrnsrkyksjkkktyouseiriritu;
    }

    private BizNumber zrnmvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNMVATYOUSEIKOU)
    public BizNumber getZrnmvatyouseikou() {
        return zrnmvatyouseikou;
    }

    public void setZrnmvatyouseikou(BizNumber pZrnmvatyouseikou) {
        zrnmvatyouseikou = pZrnmvatyouseikou;
    }

    private String zrnsisuurendourate;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUURENDOURATE)
    public String getZrnsisuurendourate() {
        return zrnsisuurendourate;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsisuurendourate(String pZrnsisuurendourate) {
        zrnsisuurendourate = pZrnsisuurendourate;
    }

    private String zrnsisuukbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUKBN)
    public String getZrnsisuukbn() {
        return zrnsisuukbn;
    }

    public void setZrnsisuukbn(String pZrnsisuukbn) {
        zrnsisuukbn = pZrnsisuukbn;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkimatukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKIMATUKAWASERATE)
    public BizNumber getZrnkimatukawaserate() {
        return zrnkimatukawaserate;
    }

    public void setZrnkimatukawaserate(BizNumber pZrnkimatukawaserate) {
        zrnkimatukawaserate = pZrnkimatukawaserate;
    }

    private BizNumber zrnkaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKAIYAKUKOUJYORITU)
    public BizNumber getZrnkaiyakukoujyoritu() {
        return zrnkaiyakukoujyoritu;
    }

    public void setZrnkaiyakukoujyoritu(BizNumber pZrnkaiyakukoujyoritu) {
        zrnkaiyakukoujyoritu = pZrnkaiyakukoujyoritu;
    }

    private BizNumber zrntumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTUMITATERIRITU)
    public BizNumber getZrntumitateriritu() {
        return zrntumitateriritu;
    }

    public void setZrntumitateriritu(BizNumber pZrntumitateriritu) {
        zrntumitateriritu = pZrntumitateriritu;
    }

    private String zrnsknnkaisiymd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSKNNKAISIYMD)
    public String getZrnsknnkaisiymd() {
        return zrnsknnkaisiymd;
    }

    public void setZrnsknnkaisiymd(String pZrnsknnkaisiymd) {
        zrnsknnkaisiymd = pZrnsknnkaisiymd;
    }

    private BizNumber zrnrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNRENDOURITU)
    public BizNumber getZrnrendouritu() {
        return zrnrendouritu;
    }

    public void setZrnrendouritu(BizNumber pZrnrendouritu) {
        zrnrendouritu = pZrnrendouritu;
    }

    private String zrnsuuriyouyobin3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSUURIYOUYOBIN3)
    public String getZrnsuuriyouyobin3() {
        return zrnsuuriyouyobin3;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsuuriyouyobin3(String pZrnsuuriyouyobin3) {
        zrnsuuriyouyobin3 = pZrnsuuriyouyobin3;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrnmvatyouseigow;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNMVATYOUSEIGOW)
    public Long getZrnmvatyouseigow() {
        return zrnmvatyouseigow;
    }

    public void setZrnmvatyouseigow(Long pZrnmvatyouseigow) {
        zrnmvatyouseigow = pZrnmvatyouseigow;
    }

    private Long zrnmvakeisanjisknnjynbkn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNMVAKEISANJISKNNJYNBKN)
    public Long getZrnmvakeisanjisknnjynbkn() {
        return zrnmvakeisanjisknnjynbkn;
    }

    public void setZrnmvakeisanjisknnjynbkn(Long pZrnmvakeisanjisknnjynbkn) {
        zrnmvakeisanjisknnjynbkn = pZrnmvakeisanjisknnjynbkn;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnkmtsisuurentumitatekn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKMTSISUURENTUMITATEKN)
    public Long getZrnkmtsisuurentumitatekn() {
        return zrnkmtsisuurentumitatekn;
    }

    public void setZrnkmtsisuurentumitatekn(Long pZrnkmtsisuurentumitatekn) {
        zrnkmtsisuurentumitatekn = pZrnkmtsisuurentumitatekn;
    }

    private Long zrnkmttirttmtttumitatekn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKMTTIRTTMTTTUMITATEKN)
    public Long getZrnkmttirttmtttumitatekn() {
        return zrnkmttirttmtttumitatekn;
    }

    public void setZrnkmttirttmtttumitatekn(Long pZrnkmttirttmtttumitatekn) {
        zrnkmttirttmtttumitatekn = pZrnkmttirttmtttumitatekn;
    }

    private Long zrnkmtsisuurentyokugotmttkn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNKMTSISUURENTYOKUGOTMTTKN)
    public Long getZrnkmtsisuurentyokugotmttkn() {
        return zrnkmtsisuurentyokugotmttkn;
    }

    public void setZrnkmtsisuurentyokugotmttkn(Long pZrnkmtsisuurentyokugotmttkn) {
        zrnkmtsisuurentyokugotmttkn = pZrnkmtsisuurentyokugotmttkn;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private String zrnsisuubbncalckijyunymd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMD)
    public String getZrnsisuubbncalckijyunymd() {
        return zrnsisuubbncalckijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymd(String pZrnsisuubbncalckijyunymd) {
        zrnsisuubbncalckijyunymd = pZrnsisuubbncalckijyunymd;
    }

    private Long zrnsisuubbntumitatekin;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKIN)
    public Long getZrnsisuubbntumitatekin() {
        return zrnsisuubbntumitatekin;
    }

    public void setZrnsisuubbntumitatekin(Long pZrnsisuubbntumitatekin) {
        zrnsisuubbntumitatekin = pZrnsisuubbntumitatekin;
    }

    private BizNumber zrntoukisisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUU)
    public BizNumber getZrntoukisisuu() {
        return zrntoukisisuu;
    }

    public void setZrntoukisisuu(BizNumber pZrntoukisisuu) {
        zrntoukisisuu = pZrntoukisisuu;
    }

    private String zrntoukisisuukijyunymd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMD)
    public String getZrntoukisisuukijyunymd() {
        return zrntoukisisuukijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymd(String pZrntoukisisuukijyunymd) {
        zrntoukisisuukijyunymd = pZrntoukisisuukijyunymd;
    }

    private BizNumber zrnzenkisisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUU)
    public BizNumber getZrnzenkisisuu() {
        return zrnzenkisisuu;
    }

    public void setZrnzenkisisuu(BizNumber pZrnzenkisisuu) {
        zrnzenkisisuu = pZrnzenkisisuu;
    }

    private String zrnzenkisisuukijyunymd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMD)
    public String getZrnzenkisisuukijyunymd() {
        return zrnzenkisisuukijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymd(String pZrnzenkisisuukijyunymd) {
        zrnzenkisisuukijyunymd = pZrnzenkisisuukijyunymd;
    }

    private BizNumber zrntmttknzoukaritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITU)
    public BizNumber getZrntmttknzoukaritu() {
        return zrntmttknzoukaritu;
    }

    public void setZrntmttknzoukaritu(BizNumber pZrntmttknzoukaritu) {
        zrntmttknzoukaritu = pZrntmttknzoukaritu;
    }

    private Long zrntoukitumimasikin;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKIN)
    public Long getZrntoukitumimasikin() {
        return zrntoukitumimasikin;
    }

    public void setZrntoukitumimasikin(Long pZrntoukitumimasikin) {
        zrntoukitumimasikin = pZrntoukitumimasikin;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnsisuubbncalckijyunymdx2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX2)
    public String getZrnsisuubbncalckijyunymdx2() {
        return zrnsisuubbncalckijyunymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx2(String pZrnsisuubbncalckijyunymdx2) {
        zrnsisuubbncalckijyunymdx2 = pZrnsisuubbncalckijyunymdx2;
    }

    private Long zrnsisuubbntumitatekinx2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX2)
    public Long getZrnsisuubbntumitatekinx2() {
        return zrnsisuubbntumitatekinx2;
    }

    public void setZrnsisuubbntumitatekinx2(Long pZrnsisuubbntumitatekinx2) {
        zrnsisuubbntumitatekinx2 = pZrnsisuubbntumitatekinx2;
    }

    private BizNumber zrntoukisisuux2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX2)
    public BizNumber getZrntoukisisuux2() {
        return zrntoukisisuux2;
    }

    public void setZrntoukisisuux2(BizNumber pZrntoukisisuux2) {
        zrntoukisisuux2 = pZrntoukisisuux2;
    }

    private String zrntoukisisuukijyunymdx2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX2)
    public String getZrntoukisisuukijyunymdx2() {
        return zrntoukisisuukijyunymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx2(String pZrntoukisisuukijyunymdx2) {
        zrntoukisisuukijyunymdx2 = pZrntoukisisuukijyunymdx2;
    }

    private BizNumber zrnzenkisisuux2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX2)
    public BizNumber getZrnzenkisisuux2() {
        return zrnzenkisisuux2;
    }

    public void setZrnzenkisisuux2(BizNumber pZrnzenkisisuux2) {
        zrnzenkisisuux2 = pZrnzenkisisuux2;
    }

    private String zrnzenkisisuukijyunymdx2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX2)
    public String getZrnzenkisisuukijyunymdx2() {
        return zrnzenkisisuukijyunymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx2(String pZrnzenkisisuukijyunymdx2) {
        zrnzenkisisuukijyunymdx2 = pZrnzenkisisuukijyunymdx2;
    }

    private BizNumber zrntmttknzoukaritux2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX2)
    public BizNumber getZrntmttknzoukaritux2() {
        return zrntmttknzoukaritux2;
    }

    public void setZrntmttknzoukaritux2(BizNumber pZrntmttknzoukaritux2) {
        zrntmttknzoukaritux2 = pZrntmttknzoukaritux2;
    }

    private Long zrntoukitumimasikinx2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX2)
    public Long getZrntoukitumimasikinx2() {
        return zrntoukitumimasikinx2;
    }

    public void setZrntoukitumimasikinx2(Long pZrntoukitumimasikinx2) {
        zrntoukitumimasikinx2 = pZrntoukitumimasikinx2;
    }

    private String zrnyobiv9x2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X2)
    public String getZrnyobiv9x2() {
        return zrnyobiv9x2;
    }

    public void setZrnyobiv9x2(String pZrnyobiv9x2) {
        zrnyobiv9x2 = pZrnyobiv9x2;
    }

    private String zrnsisuubbncalckijyunymdx3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX3)
    public String getZrnsisuubbncalckijyunymdx3() {
        return zrnsisuubbncalckijyunymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx3(String pZrnsisuubbncalckijyunymdx3) {
        zrnsisuubbncalckijyunymdx3 = pZrnsisuubbncalckijyunymdx3;
    }

    private Long zrnsisuubbntumitatekinx3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX3)
    public Long getZrnsisuubbntumitatekinx3() {
        return zrnsisuubbntumitatekinx3;
    }

    public void setZrnsisuubbntumitatekinx3(Long pZrnsisuubbntumitatekinx3) {
        zrnsisuubbntumitatekinx3 = pZrnsisuubbntumitatekinx3;
    }

    private BizNumber zrntoukisisuux3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX3)
    public BizNumber getZrntoukisisuux3() {
        return zrntoukisisuux3;
    }

    public void setZrntoukisisuux3(BizNumber pZrntoukisisuux3) {
        zrntoukisisuux3 = pZrntoukisisuux3;
    }

    private String zrntoukisisuukijyunymdx3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX3)
    public String getZrntoukisisuukijyunymdx3() {
        return zrntoukisisuukijyunymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx3(String pZrntoukisisuukijyunymdx3) {
        zrntoukisisuukijyunymdx3 = pZrntoukisisuukijyunymdx3;
    }

    private BizNumber zrnzenkisisuux3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX3)
    public BizNumber getZrnzenkisisuux3() {
        return zrnzenkisisuux3;
    }

    public void setZrnzenkisisuux3(BizNumber pZrnzenkisisuux3) {
        zrnzenkisisuux3 = pZrnzenkisisuux3;
    }

    private String zrnzenkisisuukijyunymdx3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX3)
    public String getZrnzenkisisuukijyunymdx3() {
        return zrnzenkisisuukijyunymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx3(String pZrnzenkisisuukijyunymdx3) {
        zrnzenkisisuukijyunymdx3 = pZrnzenkisisuukijyunymdx3;
    }

    private BizNumber zrntmttknzoukaritux3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX3)
    public BizNumber getZrntmttknzoukaritux3() {
        return zrntmttknzoukaritux3;
    }

    public void setZrntmttknzoukaritux3(BizNumber pZrntmttknzoukaritux3) {
        zrntmttknzoukaritux3 = pZrntmttknzoukaritux3;
    }

    private Long zrntoukitumimasikinx3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX3)
    public Long getZrntoukitumimasikinx3() {
        return zrntoukitumimasikinx3;
    }

    public void setZrntoukitumimasikinx3(Long pZrntoukitumimasikinx3) {
        zrntoukitumimasikinx3 = pZrntoukitumimasikinx3;
    }

    private String zrnyobiv9x3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X3)
    public String getZrnyobiv9x3() {
        return zrnyobiv9x3;
    }

    public void setZrnyobiv9x3(String pZrnyobiv9x3) {
        zrnyobiv9x3 = pZrnyobiv9x3;
    }

    private String zrnsisuubbncalckijyunymdx4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX4)
    public String getZrnsisuubbncalckijyunymdx4() {
        return zrnsisuubbncalckijyunymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx4(String pZrnsisuubbncalckijyunymdx4) {
        zrnsisuubbncalckijyunymdx4 = pZrnsisuubbncalckijyunymdx4;
    }

    private Long zrnsisuubbntumitatekinx4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX4)
    public Long getZrnsisuubbntumitatekinx4() {
        return zrnsisuubbntumitatekinx4;
    }

    public void setZrnsisuubbntumitatekinx4(Long pZrnsisuubbntumitatekinx4) {
        zrnsisuubbntumitatekinx4 = pZrnsisuubbntumitatekinx4;
    }

    private BizNumber zrntoukisisuux4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX4)
    public BizNumber getZrntoukisisuux4() {
        return zrntoukisisuux4;
    }

    public void setZrntoukisisuux4(BizNumber pZrntoukisisuux4) {
        zrntoukisisuux4 = pZrntoukisisuux4;
    }

    private String zrntoukisisuukijyunymdx4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX4)
    public String getZrntoukisisuukijyunymdx4() {
        return zrntoukisisuukijyunymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx4(String pZrntoukisisuukijyunymdx4) {
        zrntoukisisuukijyunymdx4 = pZrntoukisisuukijyunymdx4;
    }

    private BizNumber zrnzenkisisuux4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX4)
    public BizNumber getZrnzenkisisuux4() {
        return zrnzenkisisuux4;
    }

    public void setZrnzenkisisuux4(BizNumber pZrnzenkisisuux4) {
        zrnzenkisisuux4 = pZrnzenkisisuux4;
    }

    private String zrnzenkisisuukijyunymdx4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX4)
    public String getZrnzenkisisuukijyunymdx4() {
        return zrnzenkisisuukijyunymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx4(String pZrnzenkisisuukijyunymdx4) {
        zrnzenkisisuukijyunymdx4 = pZrnzenkisisuukijyunymdx4;
    }

    private BizNumber zrntmttknzoukaritux4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX4)
    public BizNumber getZrntmttknzoukaritux4() {
        return zrntmttknzoukaritux4;
    }

    public void setZrntmttknzoukaritux4(BizNumber pZrntmttknzoukaritux4) {
        zrntmttknzoukaritux4 = pZrntmttknzoukaritux4;
    }

    private Long zrntoukitumimasikinx4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX4)
    public Long getZrntoukitumimasikinx4() {
        return zrntoukitumimasikinx4;
    }

    public void setZrntoukitumimasikinx4(Long pZrntoukitumimasikinx4) {
        zrntoukitumimasikinx4 = pZrntoukitumimasikinx4;
    }

    private String zrnyobiv9x4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X4)
    public String getZrnyobiv9x4() {
        return zrnyobiv9x4;
    }

    public void setZrnyobiv9x4(String pZrnyobiv9x4) {
        zrnyobiv9x4 = pZrnyobiv9x4;
    }

    private String zrnsisuubbncalckijyunymdx5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX5)
    public String getZrnsisuubbncalckijyunymdx5() {
        return zrnsisuubbncalckijyunymdx5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx5(String pZrnsisuubbncalckijyunymdx5) {
        zrnsisuubbncalckijyunymdx5 = pZrnsisuubbncalckijyunymdx5;
    }

    private Long zrnsisuubbntumitatekinx5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX5)
    public Long getZrnsisuubbntumitatekinx5() {
        return zrnsisuubbntumitatekinx5;
    }

    public void setZrnsisuubbntumitatekinx5(Long pZrnsisuubbntumitatekinx5) {
        zrnsisuubbntumitatekinx5 = pZrnsisuubbntumitatekinx5;
    }

    private BizNumber zrntoukisisuux5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX5)
    public BizNumber getZrntoukisisuux5() {
        return zrntoukisisuux5;
    }

    public void setZrntoukisisuux5(BizNumber pZrntoukisisuux5) {
        zrntoukisisuux5 = pZrntoukisisuux5;
    }

    private String zrntoukisisuukijyunymdx5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX5)
    public String getZrntoukisisuukijyunymdx5() {
        return zrntoukisisuukijyunymdx5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx5(String pZrntoukisisuukijyunymdx5) {
        zrntoukisisuukijyunymdx5 = pZrntoukisisuukijyunymdx5;
    }

    private BizNumber zrnzenkisisuux5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX5)
    public BizNumber getZrnzenkisisuux5() {
        return zrnzenkisisuux5;
    }

    public void setZrnzenkisisuux5(BizNumber pZrnzenkisisuux5) {
        zrnzenkisisuux5 = pZrnzenkisisuux5;
    }

    private String zrnzenkisisuukijyunymdx5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX5)
    public String getZrnzenkisisuukijyunymdx5() {
        return zrnzenkisisuukijyunymdx5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx5(String pZrnzenkisisuukijyunymdx5) {
        zrnzenkisisuukijyunymdx5 = pZrnzenkisisuukijyunymdx5;
    }

    private BizNumber zrntmttknzoukaritux5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX5)
    public BizNumber getZrntmttknzoukaritux5() {
        return zrntmttknzoukaritux5;
    }

    public void setZrntmttknzoukaritux5(BizNumber pZrntmttknzoukaritux5) {
        zrntmttknzoukaritux5 = pZrntmttknzoukaritux5;
    }

    private Long zrntoukitumimasikinx5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX5)
    public Long getZrntoukitumimasikinx5() {
        return zrntoukitumimasikinx5;
    }

    public void setZrntoukitumimasikinx5(Long pZrntoukitumimasikinx5) {
        zrntoukitumimasikinx5 = pZrntoukitumimasikinx5;
    }

    private String zrnyobiv9x5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X5)
    public String getZrnyobiv9x5() {
        return zrnyobiv9x5;
    }

    public void setZrnyobiv9x5(String pZrnyobiv9x5) {
        zrnyobiv9x5 = pZrnyobiv9x5;
    }

    private String zrnsisuubbncalckijyunymdx6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX6)
    public String getZrnsisuubbncalckijyunymdx6() {
        return zrnsisuubbncalckijyunymdx6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx6(String pZrnsisuubbncalckijyunymdx6) {
        zrnsisuubbncalckijyunymdx6 = pZrnsisuubbncalckijyunymdx6;
    }

    private Long zrnsisuubbntumitatekinx6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX6)
    public Long getZrnsisuubbntumitatekinx6() {
        return zrnsisuubbntumitatekinx6;
    }

    public void setZrnsisuubbntumitatekinx6(Long pZrnsisuubbntumitatekinx6) {
        zrnsisuubbntumitatekinx6 = pZrnsisuubbntumitatekinx6;
    }

    private BizNumber zrntoukisisuux6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX6)
    public BizNumber getZrntoukisisuux6() {
        return zrntoukisisuux6;
    }

    public void setZrntoukisisuux6(BizNumber pZrntoukisisuux6) {
        zrntoukisisuux6 = pZrntoukisisuux6;
    }

    private String zrntoukisisuukijyunymdx6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX6)
    public String getZrntoukisisuukijyunymdx6() {
        return zrntoukisisuukijyunymdx6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx6(String pZrntoukisisuukijyunymdx6) {
        zrntoukisisuukijyunymdx6 = pZrntoukisisuukijyunymdx6;
    }

    private BizNumber zrnzenkisisuux6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX6)
    public BizNumber getZrnzenkisisuux6() {
        return zrnzenkisisuux6;
    }

    public void setZrnzenkisisuux6(BizNumber pZrnzenkisisuux6) {
        zrnzenkisisuux6 = pZrnzenkisisuux6;
    }

    private String zrnzenkisisuukijyunymdx6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX6)
    public String getZrnzenkisisuukijyunymdx6() {
        return zrnzenkisisuukijyunymdx6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx6(String pZrnzenkisisuukijyunymdx6) {
        zrnzenkisisuukijyunymdx6 = pZrnzenkisisuukijyunymdx6;
    }

    private BizNumber zrntmttknzoukaritux6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX6)
    public BizNumber getZrntmttknzoukaritux6() {
        return zrntmttknzoukaritux6;
    }

    public void setZrntmttknzoukaritux6(BizNumber pZrntmttknzoukaritux6) {
        zrntmttknzoukaritux6 = pZrntmttknzoukaritux6;
    }

    private Long zrntoukitumimasikinx6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX6)
    public Long getZrntoukitumimasikinx6() {
        return zrntoukitumimasikinx6;
    }

    public void setZrntoukitumimasikinx6(Long pZrntoukitumimasikinx6) {
        zrntoukitumimasikinx6 = pZrntoukitumimasikinx6;
    }

    private String zrnyobiv9x6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X6)
    public String getZrnyobiv9x6() {
        return zrnyobiv9x6;
    }

    public void setZrnyobiv9x6(String pZrnyobiv9x6) {
        zrnyobiv9x6 = pZrnyobiv9x6;
    }

    private String zrnsisuubbncalckijyunymdx7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX7)
    public String getZrnsisuubbncalckijyunymdx7() {
        return zrnsisuubbncalckijyunymdx7;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx7(String pZrnsisuubbncalckijyunymdx7) {
        zrnsisuubbncalckijyunymdx7 = pZrnsisuubbncalckijyunymdx7;
    }

    private Long zrnsisuubbntumitatekinx7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX7)
    public Long getZrnsisuubbntumitatekinx7() {
        return zrnsisuubbntumitatekinx7;
    }

    public void setZrnsisuubbntumitatekinx7(Long pZrnsisuubbntumitatekinx7) {
        zrnsisuubbntumitatekinx7 = pZrnsisuubbntumitatekinx7;
    }

    private BizNumber zrntoukisisuux7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX7)
    public BizNumber getZrntoukisisuux7() {
        return zrntoukisisuux7;
    }

    public void setZrntoukisisuux7(BizNumber pZrntoukisisuux7) {
        zrntoukisisuux7 = pZrntoukisisuux7;
    }

    private String zrntoukisisuukijyunymdx7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX7)
    public String getZrntoukisisuukijyunymdx7() {
        return zrntoukisisuukijyunymdx7;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx7(String pZrntoukisisuukijyunymdx7) {
        zrntoukisisuukijyunymdx7 = pZrntoukisisuukijyunymdx7;
    }

    private BizNumber zrnzenkisisuux7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX7)
    public BizNumber getZrnzenkisisuux7() {
        return zrnzenkisisuux7;
    }

    public void setZrnzenkisisuux7(BizNumber pZrnzenkisisuux7) {
        zrnzenkisisuux7 = pZrnzenkisisuux7;
    }

    private String zrnzenkisisuukijyunymdx7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX7)
    public String getZrnzenkisisuukijyunymdx7() {
        return zrnzenkisisuukijyunymdx7;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx7(String pZrnzenkisisuukijyunymdx7) {
        zrnzenkisisuukijyunymdx7 = pZrnzenkisisuukijyunymdx7;
    }

    private BizNumber zrntmttknzoukaritux7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX7)
    public BizNumber getZrntmttknzoukaritux7() {
        return zrntmttknzoukaritux7;
    }

    public void setZrntmttknzoukaritux7(BizNumber pZrntmttknzoukaritux7) {
        zrntmttknzoukaritux7 = pZrntmttknzoukaritux7;
    }

    private Long zrntoukitumimasikinx7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX7)
    public Long getZrntoukitumimasikinx7() {
        return zrntoukitumimasikinx7;
    }

    public void setZrntoukitumimasikinx7(Long pZrntoukitumimasikinx7) {
        zrntoukitumimasikinx7 = pZrntoukitumimasikinx7;
    }

    private String zrnyobiv9x7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X7)
    public String getZrnyobiv9x7() {
        return zrnyobiv9x7;
    }

    public void setZrnyobiv9x7(String pZrnyobiv9x7) {
        zrnyobiv9x7 = pZrnyobiv9x7;
    }

    private String zrnsisuubbncalckijyunymdx8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX8)
    public String getZrnsisuubbncalckijyunymdx8() {
        return zrnsisuubbncalckijyunymdx8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx8(String pZrnsisuubbncalckijyunymdx8) {
        zrnsisuubbncalckijyunymdx8 = pZrnsisuubbncalckijyunymdx8;
    }

    private Long zrnsisuubbntumitatekinx8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX8)
    public Long getZrnsisuubbntumitatekinx8() {
        return zrnsisuubbntumitatekinx8;
    }

    public void setZrnsisuubbntumitatekinx8(Long pZrnsisuubbntumitatekinx8) {
        zrnsisuubbntumitatekinx8 = pZrnsisuubbntumitatekinx8;
    }

    private BizNumber zrntoukisisuux8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX8)
    public BizNumber getZrntoukisisuux8() {
        return zrntoukisisuux8;
    }

    public void setZrntoukisisuux8(BizNumber pZrntoukisisuux8) {
        zrntoukisisuux8 = pZrntoukisisuux8;
    }

    private String zrntoukisisuukijyunymdx8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX8)
    public String getZrntoukisisuukijyunymdx8() {
        return zrntoukisisuukijyunymdx8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx8(String pZrntoukisisuukijyunymdx8) {
        zrntoukisisuukijyunymdx8 = pZrntoukisisuukijyunymdx8;
    }

    private BizNumber zrnzenkisisuux8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX8)
    public BizNumber getZrnzenkisisuux8() {
        return zrnzenkisisuux8;
    }

    public void setZrnzenkisisuux8(BizNumber pZrnzenkisisuux8) {
        zrnzenkisisuux8 = pZrnzenkisisuux8;
    }

    private String zrnzenkisisuukijyunymdx8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX8)
    public String getZrnzenkisisuukijyunymdx8() {
        return zrnzenkisisuukijyunymdx8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx8(String pZrnzenkisisuukijyunymdx8) {
        zrnzenkisisuukijyunymdx8 = pZrnzenkisisuukijyunymdx8;
    }

    private BizNumber zrntmttknzoukaritux8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX8)
    public BizNumber getZrntmttknzoukaritux8() {
        return zrntmttknzoukaritux8;
    }

    public void setZrntmttknzoukaritux8(BizNumber pZrntmttknzoukaritux8) {
        zrntmttknzoukaritux8 = pZrntmttknzoukaritux8;
    }

    private Long zrntoukitumimasikinx8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX8)
    public Long getZrntoukitumimasikinx8() {
        return zrntoukitumimasikinx8;
    }

    public void setZrntoukitumimasikinx8(Long pZrntoukitumimasikinx8) {
        zrntoukitumimasikinx8 = pZrntoukitumimasikinx8;
    }

    private String zrnyobiv9x8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X8)
    public String getZrnyobiv9x8() {
        return zrnyobiv9x8;
    }

    public void setZrnyobiv9x8(String pZrnyobiv9x8) {
        zrnyobiv9x8 = pZrnyobiv9x8;
    }

    private String zrnsisuubbncalckijyunymdx9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX9)
    public String getZrnsisuubbncalckijyunymdx9() {
        return zrnsisuubbncalckijyunymdx9;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx9(String pZrnsisuubbncalckijyunymdx9) {
        zrnsisuubbncalckijyunymdx9 = pZrnsisuubbncalckijyunymdx9;
    }

    private Long zrnsisuubbntumitatekinx9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX9)
    public Long getZrnsisuubbntumitatekinx9() {
        return zrnsisuubbntumitatekinx9;
    }

    public void setZrnsisuubbntumitatekinx9(Long pZrnsisuubbntumitatekinx9) {
        zrnsisuubbntumitatekinx9 = pZrnsisuubbntumitatekinx9;
    }

    private BizNumber zrntoukisisuux9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX9)
    public BizNumber getZrntoukisisuux9() {
        return zrntoukisisuux9;
    }

    public void setZrntoukisisuux9(BizNumber pZrntoukisisuux9) {
        zrntoukisisuux9 = pZrntoukisisuux9;
    }

    private String zrntoukisisuukijyunymdx9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX9)
    public String getZrntoukisisuukijyunymdx9() {
        return zrntoukisisuukijyunymdx9;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx9(String pZrntoukisisuukijyunymdx9) {
        zrntoukisisuukijyunymdx9 = pZrntoukisisuukijyunymdx9;
    }

    private BizNumber zrnzenkisisuux9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX9)
    public BizNumber getZrnzenkisisuux9() {
        return zrnzenkisisuux9;
    }

    public void setZrnzenkisisuux9(BizNumber pZrnzenkisisuux9) {
        zrnzenkisisuux9 = pZrnzenkisisuux9;
    }

    private String zrnzenkisisuukijyunymdx9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX9)
    public String getZrnzenkisisuukijyunymdx9() {
        return zrnzenkisisuukijyunymdx9;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx9(String pZrnzenkisisuukijyunymdx9) {
        zrnzenkisisuukijyunymdx9 = pZrnzenkisisuukijyunymdx9;
    }

    private BizNumber zrntmttknzoukaritux9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX9)
    public BizNumber getZrntmttknzoukaritux9() {
        return zrntmttknzoukaritux9;
    }

    public void setZrntmttknzoukaritux9(BizNumber pZrntmttknzoukaritux9) {
        zrntmttknzoukaritux9 = pZrntmttknzoukaritux9;
    }

    private Long zrntoukitumimasikinx9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX9)
    public Long getZrntoukitumimasikinx9() {
        return zrntoukitumimasikinx9;
    }

    public void setZrntoukitumimasikinx9(Long pZrntoukitumimasikinx9) {
        zrntoukitumimasikinx9 = pZrntoukitumimasikinx9;
    }

    private String zrnyobiv9x9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X9)
    public String getZrnyobiv9x9() {
        return zrnyobiv9x9;
    }

    public void setZrnyobiv9x9(String pZrnyobiv9x9) {
        zrnyobiv9x9 = pZrnyobiv9x9;
    }

    private String zrnsisuubbncalckijyunymdx10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX10)
    public String getZrnsisuubbncalckijyunymdx10() {
        return zrnsisuubbncalckijyunymdx10;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx10(String pZrnsisuubbncalckijyunymdx10) {
        zrnsisuubbncalckijyunymdx10 = pZrnsisuubbncalckijyunymdx10;
    }

    private Long zrnsisuubbntumitatekinx10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX10)
    public Long getZrnsisuubbntumitatekinx10() {
        return zrnsisuubbntumitatekinx10;
    }

    public void setZrnsisuubbntumitatekinx10(Long pZrnsisuubbntumitatekinx10) {
        zrnsisuubbntumitatekinx10 = pZrnsisuubbntumitatekinx10;
    }

    private BizNumber zrntoukisisuux10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX10)
    public BizNumber getZrntoukisisuux10() {
        return zrntoukisisuux10;
    }

    public void setZrntoukisisuux10(BizNumber pZrntoukisisuux10) {
        zrntoukisisuux10 = pZrntoukisisuux10;
    }

    private String zrntoukisisuukijyunymdx10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX10)
    public String getZrntoukisisuukijyunymdx10() {
        return zrntoukisisuukijyunymdx10;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx10(String pZrntoukisisuukijyunymdx10) {
        zrntoukisisuukijyunymdx10 = pZrntoukisisuukijyunymdx10;
    }

    private BizNumber zrnzenkisisuux10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX10)
    public BizNumber getZrnzenkisisuux10() {
        return zrnzenkisisuux10;
    }

    public void setZrnzenkisisuux10(BizNumber pZrnzenkisisuux10) {
        zrnzenkisisuux10 = pZrnzenkisisuux10;
    }

    private String zrnzenkisisuukijyunymdx10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX10)
    public String getZrnzenkisisuukijyunymdx10() {
        return zrnzenkisisuukijyunymdx10;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx10(String pZrnzenkisisuukijyunymdx10) {
        zrnzenkisisuukijyunymdx10 = pZrnzenkisisuukijyunymdx10;
    }

    private BizNumber zrntmttknzoukaritux10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX10)
    public BizNumber getZrntmttknzoukaritux10() {
        return zrntmttknzoukaritux10;
    }

    public void setZrntmttknzoukaritux10(BizNumber pZrntmttknzoukaritux10) {
        zrntmttknzoukaritux10 = pZrntmttknzoukaritux10;
    }

    private Long zrntoukitumimasikinx10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX10)
    public Long getZrntoukitumimasikinx10() {
        return zrntoukitumimasikinx10;
    }

    public void setZrntoukitumimasikinx10(Long pZrntoukitumimasikinx10) {
        zrntoukitumimasikinx10 = pZrntoukitumimasikinx10;
    }

    private String zrnyobiv9x10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X10)
    public String getZrnyobiv9x10() {
        return zrnyobiv9x10;
    }

    public void setZrnyobiv9x10(String pZrnyobiv9x10) {
        zrnyobiv9x10 = pZrnyobiv9x10;
    }

    private String zrnsisuubbncalckijyunymdx11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX11)
    public String getZrnsisuubbncalckijyunymdx11() {
        return zrnsisuubbncalckijyunymdx11;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx11(String pZrnsisuubbncalckijyunymdx11) {
        zrnsisuubbncalckijyunymdx11 = pZrnsisuubbncalckijyunymdx11;
    }

    private Long zrnsisuubbntumitatekinx11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX11)
    public Long getZrnsisuubbntumitatekinx11() {
        return zrnsisuubbntumitatekinx11;
    }

    public void setZrnsisuubbntumitatekinx11(Long pZrnsisuubbntumitatekinx11) {
        zrnsisuubbntumitatekinx11 = pZrnsisuubbntumitatekinx11;
    }

    private BizNumber zrntoukisisuux11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX11)
    public BizNumber getZrntoukisisuux11() {
        return zrntoukisisuux11;
    }

    public void setZrntoukisisuux11(BizNumber pZrntoukisisuux11) {
        zrntoukisisuux11 = pZrntoukisisuux11;
    }

    private String zrntoukisisuukijyunymdx11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX11)
    public String getZrntoukisisuukijyunymdx11() {
        return zrntoukisisuukijyunymdx11;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx11(String pZrntoukisisuukijyunymdx11) {
        zrntoukisisuukijyunymdx11 = pZrntoukisisuukijyunymdx11;
    }

    private BizNumber zrnzenkisisuux11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX11)
    public BizNumber getZrnzenkisisuux11() {
        return zrnzenkisisuux11;
    }

    public void setZrnzenkisisuux11(BizNumber pZrnzenkisisuux11) {
        zrnzenkisisuux11 = pZrnzenkisisuux11;
    }

    private String zrnzenkisisuukijyunymdx11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX11)
    public String getZrnzenkisisuukijyunymdx11() {
        return zrnzenkisisuukijyunymdx11;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx11(String pZrnzenkisisuukijyunymdx11) {
        zrnzenkisisuukijyunymdx11 = pZrnzenkisisuukijyunymdx11;
    }

    private BizNumber zrntmttknzoukaritux11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX11)
    public BizNumber getZrntmttknzoukaritux11() {
        return zrntmttknzoukaritux11;
    }

    public void setZrntmttknzoukaritux11(BizNumber pZrntmttknzoukaritux11) {
        zrntmttknzoukaritux11 = pZrntmttknzoukaritux11;
    }

    private Long zrntoukitumimasikinx11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX11)
    public Long getZrntoukitumimasikinx11() {
        return zrntoukitumimasikinx11;
    }

    public void setZrntoukitumimasikinx11(Long pZrntoukitumimasikinx11) {
        zrntoukitumimasikinx11 = pZrntoukitumimasikinx11;
    }

    private String zrnyobiv9x11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X11)
    public String getZrnyobiv9x11() {
        return zrnyobiv9x11;
    }

    public void setZrnyobiv9x11(String pZrnyobiv9x11) {
        zrnyobiv9x11 = pZrnyobiv9x11;
    }

    private String zrnsisuubbncalckijyunymdx12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX12)
    public String getZrnsisuubbncalckijyunymdx12() {
        return zrnsisuubbncalckijyunymdx12;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx12(String pZrnsisuubbncalckijyunymdx12) {
        zrnsisuubbncalckijyunymdx12 = pZrnsisuubbncalckijyunymdx12;
    }

    private Long zrnsisuubbntumitatekinx12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX12)
    public Long getZrnsisuubbntumitatekinx12() {
        return zrnsisuubbntumitatekinx12;
    }

    public void setZrnsisuubbntumitatekinx12(Long pZrnsisuubbntumitatekinx12) {
        zrnsisuubbntumitatekinx12 = pZrnsisuubbntumitatekinx12;
    }

    private BizNumber zrntoukisisuux12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX12)
    public BizNumber getZrntoukisisuux12() {
        return zrntoukisisuux12;
    }

    public void setZrntoukisisuux12(BizNumber pZrntoukisisuux12) {
        zrntoukisisuux12 = pZrntoukisisuux12;
    }

    private String zrntoukisisuukijyunymdx12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX12)
    public String getZrntoukisisuukijyunymdx12() {
        return zrntoukisisuukijyunymdx12;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx12(String pZrntoukisisuukijyunymdx12) {
        zrntoukisisuukijyunymdx12 = pZrntoukisisuukijyunymdx12;
    }

    private BizNumber zrnzenkisisuux12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX12)
    public BizNumber getZrnzenkisisuux12() {
        return zrnzenkisisuux12;
    }

    public void setZrnzenkisisuux12(BizNumber pZrnzenkisisuux12) {
        zrnzenkisisuux12 = pZrnzenkisisuux12;
    }

    private String zrnzenkisisuukijyunymdx12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX12)
    public String getZrnzenkisisuukijyunymdx12() {
        return zrnzenkisisuukijyunymdx12;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx12(String pZrnzenkisisuukijyunymdx12) {
        zrnzenkisisuukijyunymdx12 = pZrnzenkisisuukijyunymdx12;
    }

    private BizNumber zrntmttknzoukaritux12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX12)
    public BizNumber getZrntmttknzoukaritux12() {
        return zrntmttknzoukaritux12;
    }

    public void setZrntmttknzoukaritux12(BizNumber pZrntmttknzoukaritux12) {
        zrntmttknzoukaritux12 = pZrntmttknzoukaritux12;
    }

    private Long zrntoukitumimasikinx12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX12)
    public Long getZrntoukitumimasikinx12() {
        return zrntoukitumimasikinx12;
    }

    public void setZrntoukitumimasikinx12(Long pZrntoukitumimasikinx12) {
        zrntoukitumimasikinx12 = pZrntoukitumimasikinx12;
    }

    private String zrnyobiv9x12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X12)
    public String getZrnyobiv9x12() {
        return zrnyobiv9x12;
    }

    public void setZrnyobiv9x12(String pZrnyobiv9x12) {
        zrnyobiv9x12 = pZrnyobiv9x12;
    }

    private String zrnsisuubbncalckijyunymdx13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX13)
    public String getZrnsisuubbncalckijyunymdx13() {
        return zrnsisuubbncalckijyunymdx13;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx13(String pZrnsisuubbncalckijyunymdx13) {
        zrnsisuubbncalckijyunymdx13 = pZrnsisuubbncalckijyunymdx13;
    }

    private Long zrnsisuubbntumitatekinx13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX13)
    public Long getZrnsisuubbntumitatekinx13() {
        return zrnsisuubbntumitatekinx13;
    }

    public void setZrnsisuubbntumitatekinx13(Long pZrnsisuubbntumitatekinx13) {
        zrnsisuubbntumitatekinx13 = pZrnsisuubbntumitatekinx13;
    }

    private BizNumber zrntoukisisuux13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX13)
    public BizNumber getZrntoukisisuux13() {
        return zrntoukisisuux13;
    }

    public void setZrntoukisisuux13(BizNumber pZrntoukisisuux13) {
        zrntoukisisuux13 = pZrntoukisisuux13;
    }

    private String zrntoukisisuukijyunymdx13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX13)
    public String getZrntoukisisuukijyunymdx13() {
        return zrntoukisisuukijyunymdx13;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx13(String pZrntoukisisuukijyunymdx13) {
        zrntoukisisuukijyunymdx13 = pZrntoukisisuukijyunymdx13;
    }

    private BizNumber zrnzenkisisuux13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX13)
    public BizNumber getZrnzenkisisuux13() {
        return zrnzenkisisuux13;
    }

    public void setZrnzenkisisuux13(BizNumber pZrnzenkisisuux13) {
        zrnzenkisisuux13 = pZrnzenkisisuux13;
    }

    private String zrnzenkisisuukijyunymdx13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX13)
    public String getZrnzenkisisuukijyunymdx13() {
        return zrnzenkisisuukijyunymdx13;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx13(String pZrnzenkisisuukijyunymdx13) {
        zrnzenkisisuukijyunymdx13 = pZrnzenkisisuukijyunymdx13;
    }

    private BizNumber zrntmttknzoukaritux13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX13)
    public BizNumber getZrntmttknzoukaritux13() {
        return zrntmttknzoukaritux13;
    }

    public void setZrntmttknzoukaritux13(BizNumber pZrntmttknzoukaritux13) {
        zrntmttknzoukaritux13 = pZrntmttknzoukaritux13;
    }

    private Long zrntoukitumimasikinx13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX13)
    public Long getZrntoukitumimasikinx13() {
        return zrntoukitumimasikinx13;
    }

    public void setZrntoukitumimasikinx13(Long pZrntoukitumimasikinx13) {
        zrntoukitumimasikinx13 = pZrntoukitumimasikinx13;
    }

    private String zrnyobiv9x13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X13)
    public String getZrnyobiv9x13() {
        return zrnyobiv9x13;
    }

    public void setZrnyobiv9x13(String pZrnyobiv9x13) {
        zrnyobiv9x13 = pZrnyobiv9x13;
    }

    private String zrnsisuubbncalckijyunymdx14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX14)
    public String getZrnsisuubbncalckijyunymdx14() {
        return zrnsisuubbncalckijyunymdx14;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx14(String pZrnsisuubbncalckijyunymdx14) {
        zrnsisuubbncalckijyunymdx14 = pZrnsisuubbncalckijyunymdx14;
    }

    private Long zrnsisuubbntumitatekinx14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX14)
    public Long getZrnsisuubbntumitatekinx14() {
        return zrnsisuubbntumitatekinx14;
    }

    public void setZrnsisuubbntumitatekinx14(Long pZrnsisuubbntumitatekinx14) {
        zrnsisuubbntumitatekinx14 = pZrnsisuubbntumitatekinx14;
    }

    private BizNumber zrntoukisisuux14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX14)
    public BizNumber getZrntoukisisuux14() {
        return zrntoukisisuux14;
    }

    public void setZrntoukisisuux14(BizNumber pZrntoukisisuux14) {
        zrntoukisisuux14 = pZrntoukisisuux14;
    }

    private String zrntoukisisuukijyunymdx14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX14)
    public String getZrntoukisisuukijyunymdx14() {
        return zrntoukisisuukijyunymdx14;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx14(String pZrntoukisisuukijyunymdx14) {
        zrntoukisisuukijyunymdx14 = pZrntoukisisuukijyunymdx14;
    }

    private BizNumber zrnzenkisisuux14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX14)
    public BizNumber getZrnzenkisisuux14() {
        return zrnzenkisisuux14;
    }

    public void setZrnzenkisisuux14(BizNumber pZrnzenkisisuux14) {
        zrnzenkisisuux14 = pZrnzenkisisuux14;
    }

    private String zrnzenkisisuukijyunymdx14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX14)
    public String getZrnzenkisisuukijyunymdx14() {
        return zrnzenkisisuukijyunymdx14;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx14(String pZrnzenkisisuukijyunymdx14) {
        zrnzenkisisuukijyunymdx14 = pZrnzenkisisuukijyunymdx14;
    }

    private BizNumber zrntmttknzoukaritux14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX14)
    public BizNumber getZrntmttknzoukaritux14() {
        return zrntmttknzoukaritux14;
    }

    public void setZrntmttknzoukaritux14(BizNumber pZrntmttknzoukaritux14) {
        zrntmttknzoukaritux14 = pZrntmttknzoukaritux14;
    }

    private Long zrntoukitumimasikinx14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX14)
    public Long getZrntoukitumimasikinx14() {
        return zrntoukitumimasikinx14;
    }

    public void setZrntoukitumimasikinx14(Long pZrntoukitumimasikinx14) {
        zrntoukitumimasikinx14 = pZrntoukitumimasikinx14;
    }

    private String zrnyobiv9x14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X14)
    public String getZrnyobiv9x14() {
        return zrnyobiv9x14;
    }

    public void setZrnyobiv9x14(String pZrnyobiv9x14) {
        zrnyobiv9x14 = pZrnyobiv9x14;
    }

    private String zrnsisuubbncalckijyunymdx15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNCALCKIJYUNYMDX15)
    public String getZrnsisuubbncalckijyunymdx15() {
        return zrnsisuubbncalckijyunymdx15;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsisuubbncalckijyunymdx15(String pZrnsisuubbncalckijyunymdx15) {
        zrnsisuubbncalckijyunymdx15 = pZrnsisuubbncalckijyunymdx15;
    }

    private Long zrnsisuubbntumitatekinx15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSISUUBBNTUMITATEKINX15)
    public Long getZrnsisuubbntumitatekinx15() {
        return zrnsisuubbntumitatekinx15;
    }

    public void setZrnsisuubbntumitatekinx15(Long pZrnsisuubbntumitatekinx15) {
        zrnsisuubbntumitatekinx15 = pZrnsisuubbntumitatekinx15;
    }

    private BizNumber zrntoukisisuux15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUX15)
    public BizNumber getZrntoukisisuux15() {
        return zrntoukisisuux15;
    }

    public void setZrntoukisisuux15(BizNumber pZrntoukisisuux15) {
        zrntoukisisuux15 = pZrntoukisisuux15;
    }

    private String zrntoukisisuukijyunymdx15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKISISUUKIJYUNYMDX15)
    public String getZrntoukisisuukijyunymdx15() {
        return zrntoukisisuukijyunymdx15;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukisisuukijyunymdx15(String pZrntoukisisuukijyunymdx15) {
        zrntoukisisuukijyunymdx15 = pZrntoukisisuukijyunymdx15;
    }

    private BizNumber zrnzenkisisuux15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUX15)
    public BizNumber getZrnzenkisisuux15() {
        return zrnzenkisisuux15;
    }

    public void setZrnzenkisisuux15(BizNumber pZrnzenkisisuux15) {
        zrnzenkisisuux15 = pZrnzenkisisuux15;
    }

    private String zrnzenkisisuukijyunymdx15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNZENKISISUUKIJYUNYMDX15)
    public String getZrnzenkisisuukijyunymdx15() {
        return zrnzenkisisuukijyunymdx15;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzenkisisuukijyunymdx15(String pZrnzenkisisuukijyunymdx15) {
        zrnzenkisisuukijyunymdx15 = pZrnzenkisisuukijyunymdx15;
    }

    private BizNumber zrntmttknzoukaritux15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTMTTKNZOUKARITUX15)
    public BizNumber getZrntmttknzoukaritux15() {
        return zrntmttknzoukaritux15;
    }

    public void setZrntmttknzoukaritux15(BizNumber pZrntmttknzoukaritux15) {
        zrntmttknzoukaritux15 = pZrntmttknzoukaritux15;
    }

    private Long zrntoukitumimasikinx15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTOUKITUMIMASIKINX15)
    public Long getZrntoukitumimasikinx15() {
        return zrntoukitumimasikinx15;
    }

    public void setZrntoukitumimasikinx15(Long pZrntoukitumimasikinx15) {
        zrntoukitumimasikinx15 = pZrntoukitumimasikinx15;
    }

    private String zrnyobiv9x15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV9X15)
    public String getZrnyobiv9x15() {
        return zrnyobiv9x15;
    }

    public void setZrnyobiv9x15(String pZrnyobiv9x15) {
        zrnyobiv9x15 = pZrnyobiv9x15;
    }

    private String zrnteiritucalckijyunymd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMD)
    public String getZrnteiritucalckijyunymd() {
        return zrnteiritucalckijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymd(String pZrnteiritucalckijyunymd) {
        zrnteiritucalckijyunymd = pZrnteiritucalckijyunymd;
    }

    private Long zrnteiritutumitatekin;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKIN)
    public Long getZrnteiritutumitatekin() {
        return zrnteiritutumitatekin;
    }

    public void setZrnteiritutumitatekin(Long pZrnteiritutumitatekin) {
        zrnteiritutumitatekin = pZrnteiritutumitatekin;
    }

    private String zrnyobiv16;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16)
    public String getZrnyobiv16() {
        return zrnyobiv16;
    }

    public void setZrnyobiv16(String pZrnyobiv16) {
        zrnyobiv16 = pZrnyobiv16;
    }

    private String zrnteiritucalckijyunymdx2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX2)
    public String getZrnteiritucalckijyunymdx2() {
        return zrnteiritucalckijyunymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx2(String pZrnteiritucalckijyunymdx2) {
        zrnteiritucalckijyunymdx2 = pZrnteiritucalckijyunymdx2;
    }

    private Long zrnteiritutumitatekinx2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX2)
    public Long getZrnteiritutumitatekinx2() {
        return zrnteiritutumitatekinx2;
    }

    public void setZrnteiritutumitatekinx2(Long pZrnteiritutumitatekinx2) {
        zrnteiritutumitatekinx2 = pZrnteiritutumitatekinx2;
    }

    private String zrnyobiv16x2;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X2)
    public String getZrnyobiv16x2() {
        return zrnyobiv16x2;
    }

    public void setZrnyobiv16x2(String pZrnyobiv16x2) {
        zrnyobiv16x2 = pZrnyobiv16x2;
    }

    private String zrnteiritucalckijyunymdx3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX3)
    public String getZrnteiritucalckijyunymdx3() {
        return zrnteiritucalckijyunymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx3(String pZrnteiritucalckijyunymdx3) {
        zrnteiritucalckijyunymdx3 = pZrnteiritucalckijyunymdx3;
    }

    private Long zrnteiritutumitatekinx3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX3)
    public Long getZrnteiritutumitatekinx3() {
        return zrnteiritutumitatekinx3;
    }

    public void setZrnteiritutumitatekinx3(Long pZrnteiritutumitatekinx3) {
        zrnteiritutumitatekinx3 = pZrnteiritutumitatekinx3;
    }

    private String zrnyobiv16x3;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X3)
    public String getZrnyobiv16x3() {
        return zrnyobiv16x3;
    }

    public void setZrnyobiv16x3(String pZrnyobiv16x3) {
        zrnyobiv16x3 = pZrnyobiv16x3;
    }

    private String zrnteiritucalckijyunymdx4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX4)
    public String getZrnteiritucalckijyunymdx4() {
        return zrnteiritucalckijyunymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx4(String pZrnteiritucalckijyunymdx4) {
        zrnteiritucalckijyunymdx4 = pZrnteiritucalckijyunymdx4;
    }

    private Long zrnteiritutumitatekinx4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX4)
    public Long getZrnteiritutumitatekinx4() {
        return zrnteiritutumitatekinx4;
    }

    public void setZrnteiritutumitatekinx4(Long pZrnteiritutumitatekinx4) {
        zrnteiritutumitatekinx4 = pZrnteiritutumitatekinx4;
    }

    private String zrnyobiv16x4;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X4)
    public String getZrnyobiv16x4() {
        return zrnyobiv16x4;
    }

    public void setZrnyobiv16x4(String pZrnyobiv16x4) {
        zrnyobiv16x4 = pZrnyobiv16x4;
    }

    private String zrnteiritucalckijyunymdx5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX5)
    public String getZrnteiritucalckijyunymdx5() {
        return zrnteiritucalckijyunymdx5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx5(String pZrnteiritucalckijyunymdx5) {
        zrnteiritucalckijyunymdx5 = pZrnteiritucalckijyunymdx5;
    }

    private Long zrnteiritutumitatekinx5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX5)
    public Long getZrnteiritutumitatekinx5() {
        return zrnteiritutumitatekinx5;
    }

    public void setZrnteiritutumitatekinx5(Long pZrnteiritutumitatekinx5) {
        zrnteiritutumitatekinx5 = pZrnteiritutumitatekinx5;
    }

    private String zrnyobiv16x5;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X5)
    public String getZrnyobiv16x5() {
        return zrnyobiv16x5;
    }

    public void setZrnyobiv16x5(String pZrnyobiv16x5) {
        zrnyobiv16x5 = pZrnyobiv16x5;
    }

    private String zrnteiritucalckijyunymdx6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX6)
    public String getZrnteiritucalckijyunymdx6() {
        return zrnteiritucalckijyunymdx6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx6(String pZrnteiritucalckijyunymdx6) {
        zrnteiritucalckijyunymdx6 = pZrnteiritucalckijyunymdx6;
    }

    private Long zrnteiritutumitatekinx6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX6)
    public Long getZrnteiritutumitatekinx6() {
        return zrnteiritutumitatekinx6;
    }

    public void setZrnteiritutumitatekinx6(Long pZrnteiritutumitatekinx6) {
        zrnteiritutumitatekinx6 = pZrnteiritutumitatekinx6;
    }

    private String zrnyobiv16x6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X6)
    public String getZrnyobiv16x6() {
        return zrnyobiv16x6;
    }

    public void setZrnyobiv16x6(String pZrnyobiv16x6) {
        zrnyobiv16x6 = pZrnyobiv16x6;
    }

    private String zrnteiritucalckijyunymdx7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX7)
    public String getZrnteiritucalckijyunymdx7() {
        return zrnteiritucalckijyunymdx7;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx7(String pZrnteiritucalckijyunymdx7) {
        zrnteiritucalckijyunymdx7 = pZrnteiritucalckijyunymdx7;
    }

    private Long zrnteiritutumitatekinx7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX7)
    public Long getZrnteiritutumitatekinx7() {
        return zrnteiritutumitatekinx7;
    }

    public void setZrnteiritutumitatekinx7(Long pZrnteiritutumitatekinx7) {
        zrnteiritutumitatekinx7 = pZrnteiritutumitatekinx7;
    }

    private String zrnyobiv16x7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X7)
    public String getZrnyobiv16x7() {
        return zrnyobiv16x7;
    }

    public void setZrnyobiv16x7(String pZrnyobiv16x7) {
        zrnyobiv16x7 = pZrnyobiv16x7;
    }

    private String zrnteiritucalckijyunymdx8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX8)
    public String getZrnteiritucalckijyunymdx8() {
        return zrnteiritucalckijyunymdx8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx8(String pZrnteiritucalckijyunymdx8) {
        zrnteiritucalckijyunymdx8 = pZrnteiritucalckijyunymdx8;
    }

    private Long zrnteiritutumitatekinx8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX8)
    public Long getZrnteiritutumitatekinx8() {
        return zrnteiritutumitatekinx8;
    }

    public void setZrnteiritutumitatekinx8(Long pZrnteiritutumitatekinx8) {
        zrnteiritutumitatekinx8 = pZrnteiritutumitatekinx8;
    }

    private String zrnyobiv16x8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X8)
    public String getZrnyobiv16x8() {
        return zrnyobiv16x8;
    }

    public void setZrnyobiv16x8(String pZrnyobiv16x8) {
        zrnyobiv16x8 = pZrnyobiv16x8;
    }

    private String zrnteiritucalckijyunymdx9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX9)
    public String getZrnteiritucalckijyunymdx9() {
        return zrnteiritucalckijyunymdx9;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx9(String pZrnteiritucalckijyunymdx9) {
        zrnteiritucalckijyunymdx9 = pZrnteiritucalckijyunymdx9;
    }

    private Long zrnteiritutumitatekinx9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX9)
    public Long getZrnteiritutumitatekinx9() {
        return zrnteiritutumitatekinx9;
    }

    public void setZrnteiritutumitatekinx9(Long pZrnteiritutumitatekinx9) {
        zrnteiritutumitatekinx9 = pZrnteiritutumitatekinx9;
    }

    private String zrnyobiv16x9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X9)
    public String getZrnyobiv16x9() {
        return zrnyobiv16x9;
    }

    public void setZrnyobiv16x9(String pZrnyobiv16x9) {
        zrnyobiv16x9 = pZrnyobiv16x9;
    }

    private String zrnteiritucalckijyunymdx10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX10)
    public String getZrnteiritucalckijyunymdx10() {
        return zrnteiritucalckijyunymdx10;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx10(String pZrnteiritucalckijyunymdx10) {
        zrnteiritucalckijyunymdx10 = pZrnteiritucalckijyunymdx10;
    }

    private Long zrnteiritutumitatekinx10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX10)
    public Long getZrnteiritutumitatekinx10() {
        return zrnteiritutumitatekinx10;
    }

    public void setZrnteiritutumitatekinx10(Long pZrnteiritutumitatekinx10) {
        zrnteiritutumitatekinx10 = pZrnteiritutumitatekinx10;
    }

    private String zrnyobiv16x10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X10)
    public String getZrnyobiv16x10() {
        return zrnyobiv16x10;
    }

    public void setZrnyobiv16x10(String pZrnyobiv16x10) {
        zrnyobiv16x10 = pZrnyobiv16x10;
    }

    private String zrnteiritucalckijyunymdx11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX11)
    public String getZrnteiritucalckijyunymdx11() {
        return zrnteiritucalckijyunymdx11;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx11(String pZrnteiritucalckijyunymdx11) {
        zrnteiritucalckijyunymdx11 = pZrnteiritucalckijyunymdx11;
    }

    private Long zrnteiritutumitatekinx11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX11)
    public Long getZrnteiritutumitatekinx11() {
        return zrnteiritutumitatekinx11;
    }

    public void setZrnteiritutumitatekinx11(Long pZrnteiritutumitatekinx11) {
        zrnteiritutumitatekinx11 = pZrnteiritutumitatekinx11;
    }

    private String zrnyobiv16x11;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X11)
    public String getZrnyobiv16x11() {
        return zrnyobiv16x11;
    }

    public void setZrnyobiv16x11(String pZrnyobiv16x11) {
        zrnyobiv16x11 = pZrnyobiv16x11;
    }

    private String zrnteiritucalckijyunymdx12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX12)
    public String getZrnteiritucalckijyunymdx12() {
        return zrnteiritucalckijyunymdx12;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx12(String pZrnteiritucalckijyunymdx12) {
        zrnteiritucalckijyunymdx12 = pZrnteiritucalckijyunymdx12;
    }

    private Long zrnteiritutumitatekinx12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX12)
    public Long getZrnteiritutumitatekinx12() {
        return zrnteiritutumitatekinx12;
    }

    public void setZrnteiritutumitatekinx12(Long pZrnteiritutumitatekinx12) {
        zrnteiritutumitatekinx12 = pZrnteiritutumitatekinx12;
    }

    private String zrnyobiv16x12;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X12)
    public String getZrnyobiv16x12() {
        return zrnyobiv16x12;
    }

    public void setZrnyobiv16x12(String pZrnyobiv16x12) {
        zrnyobiv16x12 = pZrnyobiv16x12;
    }

    private String zrnteiritucalckijyunymdx13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX13)
    public String getZrnteiritucalckijyunymdx13() {
        return zrnteiritucalckijyunymdx13;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx13(String pZrnteiritucalckijyunymdx13) {
        zrnteiritucalckijyunymdx13 = pZrnteiritucalckijyunymdx13;
    }

    private Long zrnteiritutumitatekinx13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX13)
    public Long getZrnteiritutumitatekinx13() {
        return zrnteiritutumitatekinx13;
    }

    public void setZrnteiritutumitatekinx13(Long pZrnteiritutumitatekinx13) {
        zrnteiritutumitatekinx13 = pZrnteiritutumitatekinx13;
    }

    private String zrnyobiv16x13;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X13)
    public String getZrnyobiv16x13() {
        return zrnyobiv16x13;
    }

    public void setZrnyobiv16x13(String pZrnyobiv16x13) {
        zrnyobiv16x13 = pZrnyobiv16x13;
    }

    private String zrnteiritucalckijyunymdx14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX14)
    public String getZrnteiritucalckijyunymdx14() {
        return zrnteiritucalckijyunymdx14;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx14(String pZrnteiritucalckijyunymdx14) {
        zrnteiritucalckijyunymdx14 = pZrnteiritucalckijyunymdx14;
    }

    private Long zrnteiritutumitatekinx14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX14)
    public Long getZrnteiritutumitatekinx14() {
        return zrnteiritutumitatekinx14;
    }

    public void setZrnteiritutumitatekinx14(Long pZrnteiritutumitatekinx14) {
        zrnteiritutumitatekinx14 = pZrnteiritutumitatekinx14;
    }

    private String zrnyobiv16x14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X14)
    public String getZrnyobiv16x14() {
        return zrnyobiv16x14;
    }

    public void setZrnyobiv16x14(String pZrnyobiv16x14) {
        zrnyobiv16x14 = pZrnyobiv16x14;
    }

    private String zrnteiritucalckijyunymdx15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUCALCKIJYUNYMDX15)
    public String getZrnteiritucalckijyunymdx15() {
        return zrnteiritucalckijyunymdx15;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnteiritucalckijyunymdx15(String pZrnteiritucalckijyunymdx15) {
        zrnteiritucalckijyunymdx15 = pZrnteiritucalckijyunymdx15;
    }

    private Long zrnteiritutumitatekinx15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNTEIRITUTUMITATEKINX15)
    public Long getZrnteiritutumitatekinx15() {
        return zrnteiritutumitatekinx15;
    }

    public void setZrnteiritutumitatekinx15(Long pZrnteiritutumitatekinx15) {
        zrnteiritutumitatekinx15 = pZrnteiritutumitatekinx15;
    }

    private String zrnyobiv16x15;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV16X15)
    public String getZrnyobiv16x15() {
        return zrnyobiv16x15;
    }

    public void setZrnyobiv16x15(String pZrnyobiv16x15) {
        zrnyobiv16x15 = pZrnyobiv16x15;
    }

    private String zrngengakujicalckijyunymd;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNGENGAKUJICALCKIJYUNYMD)
    public String getZrngengakujicalckijyunymd() {
        return zrngengakujicalckijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrngengakujicalckijyunymd(String pZrngengakujicalckijyunymd) {
        zrngengakujicalckijyunymd = pZrngengakujicalckijyunymd;
    }

    private Long zrngengakujisisuutmttkn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNGENGAKUJISISUUTMTTKN)
    public Long getZrngengakujisisuutmttkn() {
        return zrngengakujisisuutmttkn;
    }

    public void setZrngengakujisisuutmttkn(Long pZrngengakujisisuutmttkn) {
        zrngengakujisisuutmttkn = pZrngengakujisisuutmttkn;
    }

    private Long zrngengakujiteiritutmttkn;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNGENGAKUJITEIRITUTMTTKN)
    public Long getZrngengakujiteiritutmttkn() {
        return zrngengakujiteiritutmttkn;
    }

    public void setZrngengakujiteiritutmttkn(Long pZrngengakujiteiritutmttkn) {
        zrngengakujiteiritutmttkn = pZrngengakujiteiritutmttkn;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private Long zrnyobin11x9;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIN11X9)
    public Long getZrnyobin11x9() {
        return zrnyobin11x9;
    }

    public void setZrnyobin11x9(Long pZrnyobin11x9) {
        zrnyobin11x9 = pZrnyobin11x9;
    }

    private String zrnsuuriyouyobin14;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNSUURIYOUYOBIN14)
    public String getZrnsuuriyouyobin14() {
        return zrnsuuriyouyobin14;
    }

    @Padding(mode = "left", padChar = '0', length = 14)
    public void setZrnsuuriyouyobin14(String pZrnsuuriyouyobin14) {
        zrnsuuriyouyobin14 = pZrnsuuriyouyobin14;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_RayVKnsyuyuRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }
}