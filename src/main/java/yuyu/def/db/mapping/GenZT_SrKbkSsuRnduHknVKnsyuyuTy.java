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
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.id.PKZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.GenQZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuTy;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SrKbkSsuRnduHknVKnsyuyuTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SrKbkSsuRnduHknVKnsyuyuTy}</td><td colspan="3">株価指数連動保険Ｖ検証用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_SrKbkSsuRnduHknVKnsyuyuTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin6 ztysuuriyouyobin6}</td><td>（中継用）数理用予備項目Ｎ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuurisyuruicd ztysuurisyuruicd}</td><td>（中継用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin6x2 ztysuuriyouyobin6x2}</td><td>（中継用）数理用予備項目Ｎ６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykuriagekurisagekbn ztykuriagekurisagekbn}</td><td>（中継用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin6x3 ztysuuriyouyobin6x3}</td><td>（中継用）数理用予備項目Ｎ６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrkaiyakusjkkktyouseirrt ztysrkaiyakusjkkktyouseirrt}</td><td>（中継用）数理用解約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrkyksjkkktyouseiriritu ztysrkyksjkkktyouseiriritu}</td><td>（中継用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtymvatyouseikou ztymvatyouseikou}</td><td>（中継用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysisuurendourate ztysisuurendourate}</td><td>（中継用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuukbn ztysisuukbn}</td><td>（中継用）指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykimatukawaserate ztykimatukawaserate}</td><td>（中継用）期末為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykaiyakukoujyoritu ztykaiyakukoujyoritu}</td><td>（中継用）解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytumitateriritu ztytumitateriritu}</td><td>（中継用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysknnkaisiymd ztysknnkaisiymd}</td><td>（中継用）責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouritu ztyrendouritu}</td><td>（中継用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin3 ztysuuriyouyobin3}</td><td>（中継用）数理用予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5 ztyyobiv5}</td><td>（中継用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymvatyouseigow ztymvatyouseigow}</td><td>（中継用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymvakeisanjisknnjynbkn ztymvakeisanjisknnjynbkn}</td><td>（中継用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykmtsisuurentumitatekn ztykmtsisuurentumitatekn}</td><td>（中継用）期末指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykmttirttmtttumitatekn ztykmttirttmtttumitatekn}</td><td>（中継用）期末定率積立部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykmtsisuurentyokugotmttkn ztykmtsisuurentyokugotmttkn}</td><td>（中継用）期末指数連動部分直後積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymd ztysisuubbncalckijyunymd}</td><td>（中継用）指数部分計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekin ztysisuubbntumitatekin}</td><td>（中継用）指数部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuu ztytoukisisuu}</td><td>（中継用）当期指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymd ztytoukisisuukijyunymd}</td><td>（中継用）当期指数基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuu ztyzenkisisuu}</td><td>（中継用）前期指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymd ztyzenkisisuukijyunymd}</td><td>（中継用）前期指数基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritu ztytmttknzoukaritu}</td><td>（中継用）積立金増加率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikin ztytoukitumimasikin}</td><td>（中継用）当期積増金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx2 ztysisuubbncalckijyunymdx2}</td><td>（中継用）指数部分計算基準日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx2 ztysisuubbntumitatekinx2}</td><td>（中継用）指数部分積立金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux2 ztytoukisisuux2}</td><td>（中継用）当期指数＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx2 ztytoukisisuukijyunymdx2}</td><td>（中継用）当期指数基準年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux2 ztyzenkisisuux2}</td><td>（中継用）前期指数＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx2 ztyzenkisisuukijyunymdx2}</td><td>（中継用）前期指数基準年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux2 ztytmttknzoukaritux2}</td><td>（中継用）積立金増加率＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx2 ztytoukitumimasikinx2}</td><td>（中継用）当期積増金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x2 ztyyobiv9x2}</td><td>（中継用）予備項目Ｖ９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx3 ztysisuubbncalckijyunymdx3}</td><td>（中継用）指数部分計算基準日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx3 ztysisuubbntumitatekinx3}</td><td>（中継用）指数部分積立金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux3 ztytoukisisuux3}</td><td>（中継用）当期指数＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx3 ztytoukisisuukijyunymdx3}</td><td>（中継用）当期指数基準年月日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux3 ztyzenkisisuux3}</td><td>（中継用）前期指数＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx3 ztyzenkisisuukijyunymdx3}</td><td>（中継用）前期指数基準年月日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux3 ztytmttknzoukaritux3}</td><td>（中継用）積立金増加率＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx3 ztytoukitumimasikinx3}</td><td>（中継用）当期積増金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x3 ztyyobiv9x3}</td><td>（中継用）予備項目Ｖ９＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx4 ztysisuubbncalckijyunymdx4}</td><td>（中継用）指数部分計算基準日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx4 ztysisuubbntumitatekinx4}</td><td>（中継用）指数部分積立金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux4 ztytoukisisuux4}</td><td>（中継用）当期指数＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx4 ztytoukisisuukijyunymdx4}</td><td>（中継用）当期指数基準年月日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux4 ztyzenkisisuux4}</td><td>（中継用）前期指数＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx4 ztyzenkisisuukijyunymdx4}</td><td>（中継用）前期指数基準年月日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux4 ztytmttknzoukaritux4}</td><td>（中継用）積立金増加率＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx4 ztytoukitumimasikinx4}</td><td>（中継用）当期積増金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x4 ztyyobiv9x4}</td><td>（中継用）予備項目Ｖ９＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx5 ztysisuubbncalckijyunymdx5}</td><td>（中継用）指数部分計算基準日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx5 ztysisuubbntumitatekinx5}</td><td>（中継用）指数部分積立金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux5 ztytoukisisuux5}</td><td>（中継用）当期指数＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx5 ztytoukisisuukijyunymdx5}</td><td>（中継用）当期指数基準年月日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux5 ztyzenkisisuux5}</td><td>（中継用）前期指数＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx5 ztyzenkisisuukijyunymdx5}</td><td>（中継用）前期指数基準年月日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux5 ztytmttknzoukaritux5}</td><td>（中継用）積立金増加率＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx5 ztytoukitumimasikinx5}</td><td>（中継用）当期積増金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x5 ztyyobiv9x5}</td><td>（中継用）予備項目Ｖ９＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx6 ztysisuubbncalckijyunymdx6}</td><td>（中継用）指数部分計算基準日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx6 ztysisuubbntumitatekinx6}</td><td>（中継用）指数部分積立金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux6 ztytoukisisuux6}</td><td>（中継用）当期指数＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx6 ztytoukisisuukijyunymdx6}</td><td>（中継用）当期指数基準年月日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux6 ztyzenkisisuux6}</td><td>（中継用）前期指数＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx6 ztyzenkisisuukijyunymdx6}</td><td>（中継用）前期指数基準年月日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux6 ztytmttknzoukaritux6}</td><td>（中継用）積立金増加率＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx6 ztytoukitumimasikinx6}</td><td>（中継用）当期積増金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x6 ztyyobiv9x6}</td><td>（中継用）予備項目Ｖ９＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx7 ztysisuubbncalckijyunymdx7}</td><td>（中継用）指数部分計算基準日＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx7 ztysisuubbntumitatekinx7}</td><td>（中継用）指数部分積立金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux7 ztytoukisisuux7}</td><td>（中継用）当期指数＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx7 ztytoukisisuukijyunymdx7}</td><td>（中継用）当期指数基準年月日＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux7 ztyzenkisisuux7}</td><td>（中継用）前期指数＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx7 ztyzenkisisuukijyunymdx7}</td><td>（中継用）前期指数基準年月日＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux7 ztytmttknzoukaritux7}</td><td>（中継用）積立金増加率＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx7 ztytoukitumimasikinx7}</td><td>（中継用）当期積増金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x7 ztyyobiv9x7}</td><td>（中継用）予備項目Ｖ９＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx8 ztysisuubbncalckijyunymdx8}</td><td>（中継用）指数部分計算基準日＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx8 ztysisuubbntumitatekinx8}</td><td>（中継用）指数部分積立金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux8 ztytoukisisuux8}</td><td>（中継用）当期指数＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx8 ztytoukisisuukijyunymdx8}</td><td>（中継用）当期指数基準年月日＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux8 ztyzenkisisuux8}</td><td>（中継用）前期指数＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx8 ztyzenkisisuukijyunymdx8}</td><td>（中継用）前期指数基準年月日＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux8 ztytmttknzoukaritux8}</td><td>（中継用）積立金増加率＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx8 ztytoukitumimasikinx8}</td><td>（中継用）当期積増金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x8 ztyyobiv9x8}</td><td>（中継用）予備項目Ｖ９＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx9 ztysisuubbncalckijyunymdx9}</td><td>（中継用）指数部分計算基準日＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx9 ztysisuubbntumitatekinx9}</td><td>（中継用）指数部分積立金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux9 ztytoukisisuux9}</td><td>（中継用）当期指数＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx9 ztytoukisisuukijyunymdx9}</td><td>（中継用）当期指数基準年月日＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux9 ztyzenkisisuux9}</td><td>（中継用）前期指数＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx9 ztyzenkisisuukijyunymdx9}</td><td>（中継用）前期指数基準年月日＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux9 ztytmttknzoukaritux9}</td><td>（中継用）積立金増加率＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx9 ztytoukitumimasikinx9}</td><td>（中継用）当期積増金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x9 ztyyobiv9x9}</td><td>（中継用）予備項目Ｖ９＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx10 ztysisuubbncalckijyunymdx10}</td><td>（中継用）指数部分計算基準日＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx10 ztysisuubbntumitatekinx10}</td><td>（中継用）指数部分積立金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux10 ztytoukisisuux10}</td><td>（中継用）当期指数＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx10 ztytoukisisuukijyunymdx10}</td><td>（中継用）当期指数基準年月日＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux10 ztyzenkisisuux10}</td><td>（中継用）前期指数＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx10 ztyzenkisisuukijyunymdx10}</td><td>（中継用）前期指数基準年月日＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux10 ztytmttknzoukaritux10}</td><td>（中継用）積立金増加率＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx10 ztytoukitumimasikinx10}</td><td>（中継用）当期積増金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x10 ztyyobiv9x10}</td><td>（中継用）予備項目Ｖ９＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx11 ztysisuubbncalckijyunymdx11}</td><td>（中継用）指数部分計算基準日＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx11 ztysisuubbntumitatekinx11}</td><td>（中継用）指数部分積立金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux11 ztytoukisisuux11}</td><td>（中継用）当期指数＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx11 ztytoukisisuukijyunymdx11}</td><td>（中継用）当期指数基準年月日＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux11 ztyzenkisisuux11}</td><td>（中継用）前期指数＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx11 ztyzenkisisuukijyunymdx11}</td><td>（中継用）前期指数基準年月日＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux11 ztytmttknzoukaritux11}</td><td>（中継用）積立金増加率＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx11 ztytoukitumimasikinx11}</td><td>（中継用）当期積増金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x11 ztyyobiv9x11}</td><td>（中継用）予備項目Ｖ９＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx12 ztysisuubbncalckijyunymdx12}</td><td>（中継用）指数部分計算基準日＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx12 ztysisuubbntumitatekinx12}</td><td>（中継用）指数部分積立金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux12 ztytoukisisuux12}</td><td>（中継用）当期指数＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx12 ztytoukisisuukijyunymdx12}</td><td>（中継用）当期指数基準年月日＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux12 ztyzenkisisuux12}</td><td>（中継用）前期指数＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx12 ztyzenkisisuukijyunymdx12}</td><td>（中継用）前期指数基準年月日＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux12 ztytmttknzoukaritux12}</td><td>（中継用）積立金増加率＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx12 ztytoukitumimasikinx12}</td><td>（中継用）当期積増金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x12 ztyyobiv9x12}</td><td>（中継用）予備項目Ｖ９＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx13 ztysisuubbncalckijyunymdx13}</td><td>（中継用）指数部分計算基準日＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx13 ztysisuubbntumitatekinx13}</td><td>（中継用）指数部分積立金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux13 ztytoukisisuux13}</td><td>（中継用）当期指数＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx13 ztytoukisisuukijyunymdx13}</td><td>（中継用）当期指数基準年月日＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux13 ztyzenkisisuux13}</td><td>（中継用）前期指数＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx13 ztyzenkisisuukijyunymdx13}</td><td>（中継用）前期指数基準年月日＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux13 ztytmttknzoukaritux13}</td><td>（中継用）積立金増加率＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx13 ztytoukitumimasikinx13}</td><td>（中継用）当期積増金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x13 ztyyobiv9x13}</td><td>（中継用）予備項目Ｖ９＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx14 ztysisuubbncalckijyunymdx14}</td><td>（中継用）指数部分計算基準日＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx14 ztysisuubbntumitatekinx14}</td><td>（中継用）指数部分積立金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux14 ztytoukisisuux14}</td><td>（中継用）当期指数＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx14 ztytoukisisuukijyunymdx14}</td><td>（中継用）当期指数基準年月日＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux14 ztyzenkisisuux14}</td><td>（中継用）前期指数＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx14 ztyzenkisisuukijyunymdx14}</td><td>（中継用）前期指数基準年月日＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux14 ztytmttknzoukaritux14}</td><td>（中継用）積立金増加率＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx14 ztytoukitumimasikinx14}</td><td>（中継用）当期積増金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x14 ztyyobiv9x14}</td><td>（中継用）予備項目Ｖ９＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbncalckijyunymdx15 ztysisuubbncalckijyunymdx15}</td><td>（中継用）指数部分計算基準日＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuubbntumitatekinx15 ztysisuubbntumitatekinx15}</td><td>（中継用）指数部分積立金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukisisuux15 ztytoukisisuux15}</td><td>（中継用）当期指数＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukisisuukijyunymdx15 ztytoukisisuukijyunymdx15}</td><td>（中継用）当期指数基準年月日＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuux15 ztyzenkisisuux15}</td><td>（中継用）前期指数＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzenkisisuukijyunymdx15 ztyzenkisisuukijyunymdx15}</td><td>（中継用）前期指数基準年月日＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritux15 ztytmttknzoukaritux15}</td><td>（中継用）積立金増加率＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytoukitumimasikinx15 ztytoukitumimasikinx15}</td><td>（中継用）当期積増金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x15 ztyyobiv9x15}</td><td>（中継用）予備項目Ｖ９＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymd ztyteiritucalckijyunymd}</td><td>（中継用）定率部分計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekin ztyteiritutumitatekin}</td><td>（中継用）定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16 ztyyobiv16}</td><td>（中継用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx2 ztyteiritucalckijyunymdx2}</td><td>（中継用）定率部分計算基準日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx2 ztyteiritutumitatekinx2}</td><td>（中継用）定率部分積立金＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x2 ztyyobiv16x2}</td><td>（中継用）予備項目Ｖ１６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx3 ztyteiritucalckijyunymdx3}</td><td>（中継用）定率部分計算基準日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx3 ztyteiritutumitatekinx3}</td><td>（中継用）定率部分積立金＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x3 ztyyobiv16x3}</td><td>（中継用）予備項目Ｖ１６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx4 ztyteiritucalckijyunymdx4}</td><td>（中継用）定率部分計算基準日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx4 ztyteiritutumitatekinx4}</td><td>（中継用）定率部分積立金＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x4 ztyyobiv16x4}</td><td>（中継用）予備項目Ｖ１６＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx5 ztyteiritucalckijyunymdx5}</td><td>（中継用）定率部分計算基準日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx5 ztyteiritutumitatekinx5}</td><td>（中継用）定率部分積立金＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x5 ztyyobiv16x5}</td><td>（中継用）予備項目Ｖ１６＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx6 ztyteiritucalckijyunymdx6}</td><td>（中継用）定率部分計算基準日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx6 ztyteiritutumitatekinx6}</td><td>（中継用）定率部分積立金＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x6 ztyyobiv16x6}</td><td>（中継用）予備項目Ｖ１６＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx7 ztyteiritucalckijyunymdx7}</td><td>（中継用）定率部分計算基準日＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx7 ztyteiritutumitatekinx7}</td><td>（中継用）定率部分積立金＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x7 ztyyobiv16x7}</td><td>（中継用）予備項目Ｖ１６＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx8 ztyteiritucalckijyunymdx8}</td><td>（中継用）定率部分計算基準日＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx8 ztyteiritutumitatekinx8}</td><td>（中継用）定率部分積立金＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x8 ztyyobiv16x8}</td><td>（中継用）予備項目Ｖ１６＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx9 ztyteiritucalckijyunymdx9}</td><td>（中継用）定率部分計算基準日＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx9 ztyteiritutumitatekinx9}</td><td>（中継用）定率部分積立金＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x9 ztyyobiv16x9}</td><td>（中継用）予備項目Ｖ１６＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx10 ztyteiritucalckijyunymdx10}</td><td>（中継用）定率部分計算基準日＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx10 ztyteiritutumitatekinx10}</td><td>（中継用）定率部分積立金＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x10 ztyyobiv16x10}</td><td>（中継用）予備項目Ｖ１６＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx11 ztyteiritucalckijyunymdx11}</td><td>（中継用）定率部分計算基準日＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx11 ztyteiritutumitatekinx11}</td><td>（中継用）定率部分積立金＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x11 ztyyobiv16x11}</td><td>（中継用）予備項目Ｖ１６＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx12 ztyteiritucalckijyunymdx12}</td><td>（中継用）定率部分計算基準日＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx12 ztyteiritutumitatekinx12}</td><td>（中継用）定率部分積立金＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x12 ztyyobiv16x12}</td><td>（中継用）予備項目Ｖ１６＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx13 ztyteiritucalckijyunymdx13}</td><td>（中継用）定率部分計算基準日＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx13 ztyteiritutumitatekinx13}</td><td>（中継用）定率部分積立金＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x13 ztyyobiv16x13}</td><td>（中継用）予備項目Ｖ１６＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx14 ztyteiritucalckijyunymdx14}</td><td>（中継用）定率部分計算基準日＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx14 ztyteiritutumitatekinx14}</td><td>（中継用）定率部分積立金＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x14 ztyyobiv16x14}</td><td>（中継用）予備項目Ｖ１６＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritucalckijyunymdx15 ztyteiritucalckijyunymdx15}</td><td>（中継用）定率部分計算基準日＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutumitatekinx15 ztyteiritutumitatekinx15}</td><td>（中継用）定率部分積立金＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv16x15 ztyyobiv16x15}</td><td>（中継用）予備項目Ｖ１６＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengakujicalckijyunymd ztygengakujicalckijyunymd}</td><td>（中継用）減額時計算基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengakujisisuutmttkn ztygengakujisisuutmttkn}</td><td>（中継用）減額時指数部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygengakujiteiritutmttkn ztygengakujiteiritutmttkn}</td><td>（中継用）減額時定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x9 ztyyobin11x9}</td><td>（中継用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin14 ztysuuriyouyobin14}</td><td>（中継用）数理用予備項目Ｎ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     PKZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     QZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     GenQZT_SrKbkSsuRnduHknVKnsyuyuTy
 */
@MappedSuperclass
@Table(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.TABLE_NAME)
@IdClass(value=PKZT_SrKbkSsuRnduHknVKnsyuyuTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SrKbkSsuRnduHknVKnsyuyuTy extends AbstractExDBEntity<ZT_SrKbkSsuRnduHknVKnsyuyuTy, PKZT_SrKbkSsuRnduHknVKnsyuyuTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SrKbkSsuRnduHknVKnsyuyuTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYSUURIYOUYOBIN6        = "ztysuuriyouyobin6";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSUURISYURUICD         = "ztysuurisyuruicd";
    public static final String ZTYSUURIYOUYOBIN6X2      = "ztysuuriyouyobin6x2";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYKURIAGEKURISAGEKBN    = "ztykuriagekurisagekbn";
    public static final String ZTYSUURIYOUYOBIN6X3      = "ztysuuriyouyobin6x3";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYSRKAIYAKUSJKKKTYOUSEIRRT = "ztysrkaiyakusjkkktyouseirrt";
    public static final String ZTYSRKYKSJKKKTYOUSEIRIRITU = "ztysrkyksjkkktyouseiriritu";
    public static final String ZTYMVATYOUSEIKOU         = "ztymvatyouseikou";
    public static final String ZTYSISUURENDOURATE       = "ztysisuurendourate";
    public static final String ZTYSISUUKBN              = "ztysisuukbn";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKIMATUKAWASERATE      = "ztykimatukawaserate";
    public static final String ZTYKAIYAKUKOUJYORITU     = "ztykaiyakukoujyoritu";
    public static final String ZTYTUMITATERIRITU        = "ztytumitateriritu";
    public static final String ZTYSKNNKAISIYMD          = "ztysknnkaisiymd";
    public static final String ZTYRENDOURITU            = "ztyrendouritu";
    public static final String ZTYSUURIYOUYOBIN3        = "ztysuuriyouyobin3";
    public static final String ZTYYOBIV5                = "ztyyobiv5";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYMVATYOUSEIGOW         = "ztymvatyouseigow";
    public static final String ZTYMVAKEISANJISKNNJYNBKN = "ztymvakeisanjisknnjynbkn";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYKMTSISUURENTUMITATEKN = "ztykmtsisuurentumitatekn";
    public static final String ZTYKMTTIRTTMTTTUMITATEKN = "ztykmttirttmtttumitatekn";
    public static final String ZTYKMTSISUURENTYOKUGOTMTTKN = "ztykmtsisuurentyokugotmttkn";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYSISUUBBNCALCKIJYUNYMD = "ztysisuubbncalckijyunymd";
    public static final String ZTYSISUUBBNTUMITATEKIN   = "ztysisuubbntumitatekin";
    public static final String ZTYTOUKISISUU            = "ztytoukisisuu";
    public static final String ZTYTOUKISISUUKIJYUNYMD   = "ztytoukisisuukijyunymd";
    public static final String ZTYZENKISISUU            = "ztyzenkisisuu";
    public static final String ZTYZENKISISUUKIJYUNYMD   = "ztyzenkisisuukijyunymd";
    public static final String ZTYTMTTKNZOUKARITU       = "ztytmttknzoukaritu";
    public static final String ZTYTOUKITUMIMASIKIN      = "ztytoukitumimasikin";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX2 = "ztysisuubbncalckijyunymdx2";
    public static final String ZTYSISUUBBNTUMITATEKINX2 = "ztysisuubbntumitatekinx2";
    public static final String ZTYTOUKISISUUX2          = "ztytoukisisuux2";
    public static final String ZTYTOUKISISUUKIJYUNYMDX2 = "ztytoukisisuukijyunymdx2";
    public static final String ZTYZENKISISUUX2          = "ztyzenkisisuux2";
    public static final String ZTYZENKISISUUKIJYUNYMDX2 = "ztyzenkisisuukijyunymdx2";
    public static final String ZTYTMTTKNZOUKARITUX2     = "ztytmttknzoukaritux2";
    public static final String ZTYTOUKITUMIMASIKINX2    = "ztytoukitumimasikinx2";
    public static final String ZTYYOBIV9X2              = "ztyyobiv9x2";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX3 = "ztysisuubbncalckijyunymdx3";
    public static final String ZTYSISUUBBNTUMITATEKINX3 = "ztysisuubbntumitatekinx3";
    public static final String ZTYTOUKISISUUX3          = "ztytoukisisuux3";
    public static final String ZTYTOUKISISUUKIJYUNYMDX3 = "ztytoukisisuukijyunymdx3";
    public static final String ZTYZENKISISUUX3          = "ztyzenkisisuux3";
    public static final String ZTYZENKISISUUKIJYUNYMDX3 = "ztyzenkisisuukijyunymdx3";
    public static final String ZTYTMTTKNZOUKARITUX3     = "ztytmttknzoukaritux3";
    public static final String ZTYTOUKITUMIMASIKINX3    = "ztytoukitumimasikinx3";
    public static final String ZTYYOBIV9X3              = "ztyyobiv9x3";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX4 = "ztysisuubbncalckijyunymdx4";
    public static final String ZTYSISUUBBNTUMITATEKINX4 = "ztysisuubbntumitatekinx4";
    public static final String ZTYTOUKISISUUX4          = "ztytoukisisuux4";
    public static final String ZTYTOUKISISUUKIJYUNYMDX4 = "ztytoukisisuukijyunymdx4";
    public static final String ZTYZENKISISUUX4          = "ztyzenkisisuux4";
    public static final String ZTYZENKISISUUKIJYUNYMDX4 = "ztyzenkisisuukijyunymdx4";
    public static final String ZTYTMTTKNZOUKARITUX4     = "ztytmttknzoukaritux4";
    public static final String ZTYTOUKITUMIMASIKINX4    = "ztytoukitumimasikinx4";
    public static final String ZTYYOBIV9X4              = "ztyyobiv9x4";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX5 = "ztysisuubbncalckijyunymdx5";
    public static final String ZTYSISUUBBNTUMITATEKINX5 = "ztysisuubbntumitatekinx5";
    public static final String ZTYTOUKISISUUX5          = "ztytoukisisuux5";
    public static final String ZTYTOUKISISUUKIJYUNYMDX5 = "ztytoukisisuukijyunymdx5";
    public static final String ZTYZENKISISUUX5          = "ztyzenkisisuux5";
    public static final String ZTYZENKISISUUKIJYUNYMDX5 = "ztyzenkisisuukijyunymdx5";
    public static final String ZTYTMTTKNZOUKARITUX5     = "ztytmttknzoukaritux5";
    public static final String ZTYTOUKITUMIMASIKINX5    = "ztytoukitumimasikinx5";
    public static final String ZTYYOBIV9X5              = "ztyyobiv9x5";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX6 = "ztysisuubbncalckijyunymdx6";
    public static final String ZTYSISUUBBNTUMITATEKINX6 = "ztysisuubbntumitatekinx6";
    public static final String ZTYTOUKISISUUX6          = "ztytoukisisuux6";
    public static final String ZTYTOUKISISUUKIJYUNYMDX6 = "ztytoukisisuukijyunymdx6";
    public static final String ZTYZENKISISUUX6          = "ztyzenkisisuux6";
    public static final String ZTYZENKISISUUKIJYUNYMDX6 = "ztyzenkisisuukijyunymdx6";
    public static final String ZTYTMTTKNZOUKARITUX6     = "ztytmttknzoukaritux6";
    public static final String ZTYTOUKITUMIMASIKINX6    = "ztytoukitumimasikinx6";
    public static final String ZTYYOBIV9X6              = "ztyyobiv9x6";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX7 = "ztysisuubbncalckijyunymdx7";
    public static final String ZTYSISUUBBNTUMITATEKINX7 = "ztysisuubbntumitatekinx7";
    public static final String ZTYTOUKISISUUX7          = "ztytoukisisuux7";
    public static final String ZTYTOUKISISUUKIJYUNYMDX7 = "ztytoukisisuukijyunymdx7";
    public static final String ZTYZENKISISUUX7          = "ztyzenkisisuux7";
    public static final String ZTYZENKISISUUKIJYUNYMDX7 = "ztyzenkisisuukijyunymdx7";
    public static final String ZTYTMTTKNZOUKARITUX7     = "ztytmttknzoukaritux7";
    public static final String ZTYTOUKITUMIMASIKINX7    = "ztytoukitumimasikinx7";
    public static final String ZTYYOBIV9X7              = "ztyyobiv9x7";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX8 = "ztysisuubbncalckijyunymdx8";
    public static final String ZTYSISUUBBNTUMITATEKINX8 = "ztysisuubbntumitatekinx8";
    public static final String ZTYTOUKISISUUX8          = "ztytoukisisuux8";
    public static final String ZTYTOUKISISUUKIJYUNYMDX8 = "ztytoukisisuukijyunymdx8";
    public static final String ZTYZENKISISUUX8          = "ztyzenkisisuux8";
    public static final String ZTYZENKISISUUKIJYUNYMDX8 = "ztyzenkisisuukijyunymdx8";
    public static final String ZTYTMTTKNZOUKARITUX8     = "ztytmttknzoukaritux8";
    public static final String ZTYTOUKITUMIMASIKINX8    = "ztytoukitumimasikinx8";
    public static final String ZTYYOBIV9X8              = "ztyyobiv9x8";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX9 = "ztysisuubbncalckijyunymdx9";
    public static final String ZTYSISUUBBNTUMITATEKINX9 = "ztysisuubbntumitatekinx9";
    public static final String ZTYTOUKISISUUX9          = "ztytoukisisuux9";
    public static final String ZTYTOUKISISUUKIJYUNYMDX9 = "ztytoukisisuukijyunymdx9";
    public static final String ZTYZENKISISUUX9          = "ztyzenkisisuux9";
    public static final String ZTYZENKISISUUKIJYUNYMDX9 = "ztyzenkisisuukijyunymdx9";
    public static final String ZTYTMTTKNZOUKARITUX9     = "ztytmttknzoukaritux9";
    public static final String ZTYTOUKITUMIMASIKINX9    = "ztytoukitumimasikinx9";
    public static final String ZTYYOBIV9X9              = "ztyyobiv9x9";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX10 = "ztysisuubbncalckijyunymdx10";
    public static final String ZTYSISUUBBNTUMITATEKINX10 = "ztysisuubbntumitatekinx10";
    public static final String ZTYTOUKISISUUX10         = "ztytoukisisuux10";
    public static final String ZTYTOUKISISUUKIJYUNYMDX10 = "ztytoukisisuukijyunymdx10";
    public static final String ZTYZENKISISUUX10         = "ztyzenkisisuux10";
    public static final String ZTYZENKISISUUKIJYUNYMDX10 = "ztyzenkisisuukijyunymdx10";
    public static final String ZTYTMTTKNZOUKARITUX10    = "ztytmttknzoukaritux10";
    public static final String ZTYTOUKITUMIMASIKINX10   = "ztytoukitumimasikinx10";
    public static final String ZTYYOBIV9X10             = "ztyyobiv9x10";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX11 = "ztysisuubbncalckijyunymdx11";
    public static final String ZTYSISUUBBNTUMITATEKINX11 = "ztysisuubbntumitatekinx11";
    public static final String ZTYTOUKISISUUX11         = "ztytoukisisuux11";
    public static final String ZTYTOUKISISUUKIJYUNYMDX11 = "ztytoukisisuukijyunymdx11";
    public static final String ZTYZENKISISUUX11         = "ztyzenkisisuux11";
    public static final String ZTYZENKISISUUKIJYUNYMDX11 = "ztyzenkisisuukijyunymdx11";
    public static final String ZTYTMTTKNZOUKARITUX11    = "ztytmttknzoukaritux11";
    public static final String ZTYTOUKITUMIMASIKINX11   = "ztytoukitumimasikinx11";
    public static final String ZTYYOBIV9X11             = "ztyyobiv9x11";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX12 = "ztysisuubbncalckijyunymdx12";
    public static final String ZTYSISUUBBNTUMITATEKINX12 = "ztysisuubbntumitatekinx12";
    public static final String ZTYTOUKISISUUX12         = "ztytoukisisuux12";
    public static final String ZTYTOUKISISUUKIJYUNYMDX12 = "ztytoukisisuukijyunymdx12";
    public static final String ZTYZENKISISUUX12         = "ztyzenkisisuux12";
    public static final String ZTYZENKISISUUKIJYUNYMDX12 = "ztyzenkisisuukijyunymdx12";
    public static final String ZTYTMTTKNZOUKARITUX12    = "ztytmttknzoukaritux12";
    public static final String ZTYTOUKITUMIMASIKINX12   = "ztytoukitumimasikinx12";
    public static final String ZTYYOBIV9X12             = "ztyyobiv9x12";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX13 = "ztysisuubbncalckijyunymdx13";
    public static final String ZTYSISUUBBNTUMITATEKINX13 = "ztysisuubbntumitatekinx13";
    public static final String ZTYTOUKISISUUX13         = "ztytoukisisuux13";
    public static final String ZTYTOUKISISUUKIJYUNYMDX13 = "ztytoukisisuukijyunymdx13";
    public static final String ZTYZENKISISUUX13         = "ztyzenkisisuux13";
    public static final String ZTYZENKISISUUKIJYUNYMDX13 = "ztyzenkisisuukijyunymdx13";
    public static final String ZTYTMTTKNZOUKARITUX13    = "ztytmttknzoukaritux13";
    public static final String ZTYTOUKITUMIMASIKINX13   = "ztytoukitumimasikinx13";
    public static final String ZTYYOBIV9X13             = "ztyyobiv9x13";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX14 = "ztysisuubbncalckijyunymdx14";
    public static final String ZTYSISUUBBNTUMITATEKINX14 = "ztysisuubbntumitatekinx14";
    public static final String ZTYTOUKISISUUX14         = "ztytoukisisuux14";
    public static final String ZTYTOUKISISUUKIJYUNYMDX14 = "ztytoukisisuukijyunymdx14";
    public static final String ZTYZENKISISUUX14         = "ztyzenkisisuux14";
    public static final String ZTYZENKISISUUKIJYUNYMDX14 = "ztyzenkisisuukijyunymdx14";
    public static final String ZTYTMTTKNZOUKARITUX14    = "ztytmttknzoukaritux14";
    public static final String ZTYTOUKITUMIMASIKINX14   = "ztytoukitumimasikinx14";
    public static final String ZTYYOBIV9X14             = "ztyyobiv9x14";
    public static final String ZTYSISUUBBNCALCKIJYUNYMDX15 = "ztysisuubbncalckijyunymdx15";
    public static final String ZTYSISUUBBNTUMITATEKINX15 = "ztysisuubbntumitatekinx15";
    public static final String ZTYTOUKISISUUX15         = "ztytoukisisuux15";
    public static final String ZTYTOUKISISUUKIJYUNYMDX15 = "ztytoukisisuukijyunymdx15";
    public static final String ZTYZENKISISUUX15         = "ztyzenkisisuux15";
    public static final String ZTYZENKISISUUKIJYUNYMDX15 = "ztyzenkisisuukijyunymdx15";
    public static final String ZTYTMTTKNZOUKARITUX15    = "ztytmttknzoukaritux15";
    public static final String ZTYTOUKITUMIMASIKINX15   = "ztytoukitumimasikinx15";
    public static final String ZTYYOBIV9X15             = "ztyyobiv9x15";
    public static final String ZTYTEIRITUCALCKIJYUNYMD  = "ztyteiritucalckijyunymd";
    public static final String ZTYTEIRITUTUMITATEKIN    = "ztyteiritutumitatekin";
    public static final String ZTYYOBIV16               = "ztyyobiv16";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX2 = "ztyteiritucalckijyunymdx2";
    public static final String ZTYTEIRITUTUMITATEKINX2  = "ztyteiritutumitatekinx2";
    public static final String ZTYYOBIV16X2             = "ztyyobiv16x2";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX3 = "ztyteiritucalckijyunymdx3";
    public static final String ZTYTEIRITUTUMITATEKINX3  = "ztyteiritutumitatekinx3";
    public static final String ZTYYOBIV16X3             = "ztyyobiv16x3";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX4 = "ztyteiritucalckijyunymdx4";
    public static final String ZTYTEIRITUTUMITATEKINX4  = "ztyteiritutumitatekinx4";
    public static final String ZTYYOBIV16X4             = "ztyyobiv16x4";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX5 = "ztyteiritucalckijyunymdx5";
    public static final String ZTYTEIRITUTUMITATEKINX5  = "ztyteiritutumitatekinx5";
    public static final String ZTYYOBIV16X5             = "ztyyobiv16x5";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX6 = "ztyteiritucalckijyunymdx6";
    public static final String ZTYTEIRITUTUMITATEKINX6  = "ztyteiritutumitatekinx6";
    public static final String ZTYYOBIV16X6             = "ztyyobiv16x6";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX7 = "ztyteiritucalckijyunymdx7";
    public static final String ZTYTEIRITUTUMITATEKINX7  = "ztyteiritutumitatekinx7";
    public static final String ZTYYOBIV16X7             = "ztyyobiv16x7";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX8 = "ztyteiritucalckijyunymdx8";
    public static final String ZTYTEIRITUTUMITATEKINX8  = "ztyteiritutumitatekinx8";
    public static final String ZTYYOBIV16X8             = "ztyyobiv16x8";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX9 = "ztyteiritucalckijyunymdx9";
    public static final String ZTYTEIRITUTUMITATEKINX9  = "ztyteiritutumitatekinx9";
    public static final String ZTYYOBIV16X9             = "ztyyobiv16x9";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX10 = "ztyteiritucalckijyunymdx10";
    public static final String ZTYTEIRITUTUMITATEKINX10 = "ztyteiritutumitatekinx10";
    public static final String ZTYYOBIV16X10            = "ztyyobiv16x10";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX11 = "ztyteiritucalckijyunymdx11";
    public static final String ZTYTEIRITUTUMITATEKINX11 = "ztyteiritutumitatekinx11";
    public static final String ZTYYOBIV16X11            = "ztyyobiv16x11";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX12 = "ztyteiritucalckijyunymdx12";
    public static final String ZTYTEIRITUTUMITATEKINX12 = "ztyteiritutumitatekinx12";
    public static final String ZTYYOBIV16X12            = "ztyyobiv16x12";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX13 = "ztyteiritucalckijyunymdx13";
    public static final String ZTYTEIRITUTUMITATEKINX13 = "ztyteiritutumitatekinx13";
    public static final String ZTYYOBIV16X13            = "ztyyobiv16x13";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX14 = "ztyteiritucalckijyunymdx14";
    public static final String ZTYTEIRITUTUMITATEKINX14 = "ztyteiritutumitatekinx14";
    public static final String ZTYYOBIV16X14            = "ztyyobiv16x14";
    public static final String ZTYTEIRITUCALCKIJYUNYMDX15 = "ztyteiritucalckijyunymdx15";
    public static final String ZTYTEIRITUTUMITATEKINX15 = "ztyteiritutumitatekinx15";
    public static final String ZTYYOBIV16X15            = "ztyyobiv16x15";
    public static final String ZTYGENGAKUJICALCKIJYUNYMD = "ztygengakujicalckijyunymd";
    public static final String ZTYGENGAKUJISISUUTMTTKN  = "ztygengakujisisuutmttkn";
    public static final String ZTYGENGAKUJITEIRITUTMTTKN = "ztygengakujiteiritutmttkn";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYYOBIN11X9             = "ztyyobin11x9";
    public static final String ZTYSUURIYOUYOBIN14       = "ztysuuriyouyobin14";
    public static final String ZTYYOBIV20               = "ztyyobiv20";

    private final PKZT_SrKbkSsuRnduHknVKnsyuyuTy primaryKey;

    public GenZT_SrKbkSsuRnduHknVKnsyuyuTy() {
        primaryKey = new PKZT_SrKbkSsuRnduHknVKnsyuyuTy();
    }

    public GenZT_SrKbkSsuRnduHknVKnsyuyuTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_SrKbkSsuRnduHknVKnsyuyuTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_SrKbkSsuRnduHknVKnsyuyuTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SrKbkSsuRnduHknVKnsyuyuTy> getMetaClass() {
        return QZT_SrKbkSsuRnduHknVKnsyuyuTy.class;
    }

    @Id
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztysuuriyouyobin6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSUURIYOUYOBIN6)
    public String getZtysuuriyouyobin6() {
        return ztysuuriyouyobin6;
    }

    public void setZtysuuriyouyobin6(String pZtysuuriyouyobin6) {
        ztysuuriyouyobin6 = pZtysuuriyouyobin6;
    }

    private String ztyyobiv12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztysuuriyouyobin6x2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSUURIYOUYOBIN6X2)
    public String getZtysuuriyouyobin6x2() {
        return ztysuuriyouyobin6x2;
    }

    public void setZtysuuriyouyobin6x2(String pZtysuuriyouyobin6x2) {
        ztysuuriyouyobin6x2 = pZtysuuriyouyobin6x2;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztykykymd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztykuriagekurisagekbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKURIAGEKURISAGEKBN)
    public String getZtykuriagekurisagekbn() {
        return ztykuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykuriagekurisagekbn(String pZtykuriagekurisagekbn) {
        ztykuriagekurisagekbn = pZtykuriagekurisagekbn;
    }

    private String ztysuuriyouyobin6x3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSUURIYOUYOBIN6X3)
    public String getZtysuuriyouyobin6x3() {
        return ztysuuriyouyobin6x3;
    }

    public void setZtysuuriyouyobin6x3(String pZtysuuriyouyobin6x3) {
        ztysuuriyouyobin6x3 = pZtysuuriyouyobin6x3;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private BizNumber ztysrkaiyakusjkkktyouseirrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSRKAIYAKUSJKKKTYOUSEIRRT)
    public BizNumber getZtysrkaiyakusjkkktyouseirrt() {
        return ztysrkaiyakusjkkktyouseirrt;
    }

    public void setZtysrkaiyakusjkkktyouseirrt(BizNumber pZtysrkaiyakusjkkktyouseirrt) {
        ztysrkaiyakusjkkktyouseirrt = pZtysrkaiyakusjkkktyouseirrt;
    }

    private BizNumber ztysrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZtysrkyksjkkktyouseiriritu() {
        return ztysrkyksjkkktyouseiriritu;
    }

    public void setZtysrkyksjkkktyouseiriritu(BizNumber pZtysrkyksjkkktyouseiriritu) {
        ztysrkyksjkkktyouseiriritu = pZtysrkyksjkkktyouseiriritu;
    }

    private BizNumber ztymvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYMVATYOUSEIKOU)
    public BizNumber getZtymvatyouseikou() {
        return ztymvatyouseikou;
    }

    public void setZtymvatyouseikou(BizNumber pZtymvatyouseikou) {
        ztymvatyouseikou = pZtymvatyouseikou;
    }

    private String ztysisuurendourate;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUURENDOURATE)
    public String getZtysisuurendourate() {
        return ztysisuurendourate;
    }

    public void setZtysisuurendourate(String pZtysisuurendourate) {
        ztysisuurendourate = pZtysisuurendourate;
    }

    private String ztysisuukbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUKBN)
    public String getZtysisuukbn() {
        return ztysisuukbn;
    }

    public void setZtysisuukbn(String pZtysisuukbn) {
        ztysisuukbn = pZtysisuukbn;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykimatukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKIMATUKAWASERATE)
    public BizNumber getZtykimatukawaserate() {
        return ztykimatukawaserate;
    }

    public void setZtykimatukawaserate(BizNumber pZtykimatukawaserate) {
        ztykimatukawaserate = pZtykimatukawaserate;
    }

    private BizNumber ztykaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKAIYAKUKOUJYORITU)
    public BizNumber getZtykaiyakukoujyoritu() {
        return ztykaiyakukoujyoritu;
    }

    public void setZtykaiyakukoujyoritu(BizNumber pZtykaiyakukoujyoritu) {
        ztykaiyakukoujyoritu = pZtykaiyakukoujyoritu;
    }

    private BizNumber ztytumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTUMITATERIRITU)
    public BizNumber getZtytumitateriritu() {
        return ztytumitateriritu;
    }

    public void setZtytumitateriritu(BizNumber pZtytumitateriritu) {
        ztytumitateriritu = pZtytumitateriritu;
    }

    private String ztysknnkaisiymd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSKNNKAISIYMD)
    public String getZtysknnkaisiymd() {
        return ztysknnkaisiymd;
    }

    public void setZtysknnkaisiymd(String pZtysknnkaisiymd) {
        ztysknnkaisiymd = pZtysknnkaisiymd;
    }

    private BizNumber ztyrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYRENDOURITU)
    public BizNumber getZtyrendouritu() {
        return ztyrendouritu;
    }

    public void setZtyrendouritu(BizNumber pZtyrendouritu) {
        ztyrendouritu = pZtyrendouritu;
    }

    private String ztysuuriyouyobin3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSUURIYOUYOBIN3)
    public String getZtysuuriyouyobin3() {
        return ztysuuriyouyobin3;
    }

    public void setZtysuuriyouyobin3(String pZtysuuriyouyobin3) {
        ztysuuriyouyobin3 = pZtysuuriyouyobin3;
    }

    private String ztyyobiv5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztymvatyouseigow;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYMVATYOUSEIGOW)
    public Long getZtymvatyouseigow() {
        return ztymvatyouseigow;
    }

    public void setZtymvatyouseigow(Long pZtymvatyouseigow) {
        ztymvatyouseigow = pZtymvatyouseigow;
    }

    private Long ztymvakeisanjisknnjynbkn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYMVAKEISANJISKNNJYNBKN)
    public Long getZtymvakeisanjisknnjynbkn() {
        return ztymvakeisanjisknnjynbkn;
    }

    public void setZtymvakeisanjisknnjynbkn(Long pZtymvakeisanjisknnjynbkn) {
        ztymvakeisanjisknnjynbkn = pZtymvakeisanjisknnjynbkn;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztykmtsisuurentumitatekn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKMTSISUURENTUMITATEKN)
    public Long getZtykmtsisuurentumitatekn() {
        return ztykmtsisuurentumitatekn;
    }

    public void setZtykmtsisuurentumitatekn(Long pZtykmtsisuurentumitatekn) {
        ztykmtsisuurentumitatekn = pZtykmtsisuurentumitatekn;
    }

    private Long ztykmttirttmtttumitatekn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKMTTIRTTMTTTUMITATEKN)
    public Long getZtykmttirttmtttumitatekn() {
        return ztykmttirttmtttumitatekn;
    }

    public void setZtykmttirttmtttumitatekn(Long pZtykmttirttmtttumitatekn) {
        ztykmttirttmtttumitatekn = pZtykmttirttmtttumitatekn;
    }

    private Long ztykmtsisuurentyokugotmttkn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYKMTSISUURENTYOKUGOTMTTKN)
    public Long getZtykmtsisuurentyokugotmttkn() {
        return ztykmtsisuurentyokugotmttkn;
    }

    public void setZtykmtsisuurentyokugotmttkn(Long pZtykmtsisuurentyokugotmttkn) {
        ztykmtsisuurentyokugotmttkn = pZtykmtsisuurentyokugotmttkn;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private String ztysisuubbncalckijyunymd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMD)
    public String getZtysisuubbncalckijyunymd() {
        return ztysisuubbncalckijyunymd;
    }

    public void setZtysisuubbncalckijyunymd(String pZtysisuubbncalckijyunymd) {
        ztysisuubbncalckijyunymd = pZtysisuubbncalckijyunymd;
    }

    private Long ztysisuubbntumitatekin;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKIN)
    public Long getZtysisuubbntumitatekin() {
        return ztysisuubbntumitatekin;
    }

    public void setZtysisuubbntumitatekin(Long pZtysisuubbntumitatekin) {
        ztysisuubbntumitatekin = pZtysisuubbntumitatekin;
    }

    private BizNumber ztytoukisisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUU)
    public BizNumber getZtytoukisisuu() {
        return ztytoukisisuu;
    }

    public void setZtytoukisisuu(BizNumber pZtytoukisisuu) {
        ztytoukisisuu = pZtytoukisisuu;
    }

    private String ztytoukisisuukijyunymd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMD)
    public String getZtytoukisisuukijyunymd() {
        return ztytoukisisuukijyunymd;
    }

    public void setZtytoukisisuukijyunymd(String pZtytoukisisuukijyunymd) {
        ztytoukisisuukijyunymd = pZtytoukisisuukijyunymd;
    }

    private BizNumber ztyzenkisisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUU)
    public BizNumber getZtyzenkisisuu() {
        return ztyzenkisisuu;
    }

    public void setZtyzenkisisuu(BizNumber pZtyzenkisisuu) {
        ztyzenkisisuu = pZtyzenkisisuu;
    }

    private String ztyzenkisisuukijyunymd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMD)
    public String getZtyzenkisisuukijyunymd() {
        return ztyzenkisisuukijyunymd;
    }

    public void setZtyzenkisisuukijyunymd(String pZtyzenkisisuukijyunymd) {
        ztyzenkisisuukijyunymd = pZtyzenkisisuukijyunymd;
    }

    private BizNumber ztytmttknzoukaritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITU)
    public BizNumber getZtytmttknzoukaritu() {
        return ztytmttknzoukaritu;
    }

    public void setZtytmttknzoukaritu(BizNumber pZtytmttknzoukaritu) {
        ztytmttknzoukaritu = pZtytmttknzoukaritu;
    }

    private Long ztytoukitumimasikin;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKIN)
    public Long getZtytoukitumimasikin() {
        return ztytoukitumimasikin;
    }

    public void setZtytoukitumimasikin(Long pZtytoukitumimasikin) {
        ztytoukitumimasikin = pZtytoukitumimasikin;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztysisuubbncalckijyunymdx2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX2)
    public String getZtysisuubbncalckijyunymdx2() {
        return ztysisuubbncalckijyunymdx2;
    }

    public void setZtysisuubbncalckijyunymdx2(String pZtysisuubbncalckijyunymdx2) {
        ztysisuubbncalckijyunymdx2 = pZtysisuubbncalckijyunymdx2;
    }

    private Long ztysisuubbntumitatekinx2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX2)
    public Long getZtysisuubbntumitatekinx2() {
        return ztysisuubbntumitatekinx2;
    }

    public void setZtysisuubbntumitatekinx2(Long pZtysisuubbntumitatekinx2) {
        ztysisuubbntumitatekinx2 = pZtysisuubbntumitatekinx2;
    }

    private BizNumber ztytoukisisuux2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX2)
    public BizNumber getZtytoukisisuux2() {
        return ztytoukisisuux2;
    }

    public void setZtytoukisisuux2(BizNumber pZtytoukisisuux2) {
        ztytoukisisuux2 = pZtytoukisisuux2;
    }

    private String ztytoukisisuukijyunymdx2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX2)
    public String getZtytoukisisuukijyunymdx2() {
        return ztytoukisisuukijyunymdx2;
    }

    public void setZtytoukisisuukijyunymdx2(String pZtytoukisisuukijyunymdx2) {
        ztytoukisisuukijyunymdx2 = pZtytoukisisuukijyunymdx2;
    }

    private BizNumber ztyzenkisisuux2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX2)
    public BizNumber getZtyzenkisisuux2() {
        return ztyzenkisisuux2;
    }

    public void setZtyzenkisisuux2(BizNumber pZtyzenkisisuux2) {
        ztyzenkisisuux2 = pZtyzenkisisuux2;
    }

    private String ztyzenkisisuukijyunymdx2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX2)
    public String getZtyzenkisisuukijyunymdx2() {
        return ztyzenkisisuukijyunymdx2;
    }

    public void setZtyzenkisisuukijyunymdx2(String pZtyzenkisisuukijyunymdx2) {
        ztyzenkisisuukijyunymdx2 = pZtyzenkisisuukijyunymdx2;
    }

    private BizNumber ztytmttknzoukaritux2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX2)
    public BizNumber getZtytmttknzoukaritux2() {
        return ztytmttknzoukaritux2;
    }

    public void setZtytmttknzoukaritux2(BizNumber pZtytmttknzoukaritux2) {
        ztytmttknzoukaritux2 = pZtytmttknzoukaritux2;
    }

    private Long ztytoukitumimasikinx2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX2)
    public Long getZtytoukitumimasikinx2() {
        return ztytoukitumimasikinx2;
    }

    public void setZtytoukitumimasikinx2(Long pZtytoukitumimasikinx2) {
        ztytoukitumimasikinx2 = pZtytoukitumimasikinx2;
    }

    private String ztyyobiv9x2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X2)
    public String getZtyyobiv9x2() {
        return ztyyobiv9x2;
    }

    public void setZtyyobiv9x2(String pZtyyobiv9x2) {
        ztyyobiv9x2 = pZtyyobiv9x2;
    }

    private String ztysisuubbncalckijyunymdx3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX3)
    public String getZtysisuubbncalckijyunymdx3() {
        return ztysisuubbncalckijyunymdx3;
    }

    public void setZtysisuubbncalckijyunymdx3(String pZtysisuubbncalckijyunymdx3) {
        ztysisuubbncalckijyunymdx3 = pZtysisuubbncalckijyunymdx3;
    }

    private Long ztysisuubbntumitatekinx3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX3)
    public Long getZtysisuubbntumitatekinx3() {
        return ztysisuubbntumitatekinx3;
    }

    public void setZtysisuubbntumitatekinx3(Long pZtysisuubbntumitatekinx3) {
        ztysisuubbntumitatekinx3 = pZtysisuubbntumitatekinx3;
    }

    private BizNumber ztytoukisisuux3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX3)
    public BizNumber getZtytoukisisuux3() {
        return ztytoukisisuux3;
    }

    public void setZtytoukisisuux3(BizNumber pZtytoukisisuux3) {
        ztytoukisisuux3 = pZtytoukisisuux3;
    }

    private String ztytoukisisuukijyunymdx3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX3)
    public String getZtytoukisisuukijyunymdx3() {
        return ztytoukisisuukijyunymdx3;
    }

    public void setZtytoukisisuukijyunymdx3(String pZtytoukisisuukijyunymdx3) {
        ztytoukisisuukijyunymdx3 = pZtytoukisisuukijyunymdx3;
    }

    private BizNumber ztyzenkisisuux3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX3)
    public BizNumber getZtyzenkisisuux3() {
        return ztyzenkisisuux3;
    }

    public void setZtyzenkisisuux3(BizNumber pZtyzenkisisuux3) {
        ztyzenkisisuux3 = pZtyzenkisisuux3;
    }

    private String ztyzenkisisuukijyunymdx3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX3)
    public String getZtyzenkisisuukijyunymdx3() {
        return ztyzenkisisuukijyunymdx3;
    }

    public void setZtyzenkisisuukijyunymdx3(String pZtyzenkisisuukijyunymdx3) {
        ztyzenkisisuukijyunymdx3 = pZtyzenkisisuukijyunymdx3;
    }

    private BizNumber ztytmttknzoukaritux3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX3)
    public BizNumber getZtytmttknzoukaritux3() {
        return ztytmttknzoukaritux3;
    }

    public void setZtytmttknzoukaritux3(BizNumber pZtytmttknzoukaritux3) {
        ztytmttknzoukaritux3 = pZtytmttknzoukaritux3;
    }

    private Long ztytoukitumimasikinx3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX3)
    public Long getZtytoukitumimasikinx3() {
        return ztytoukitumimasikinx3;
    }

    public void setZtytoukitumimasikinx3(Long pZtytoukitumimasikinx3) {
        ztytoukitumimasikinx3 = pZtytoukitumimasikinx3;
    }

    private String ztyyobiv9x3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X3)
    public String getZtyyobiv9x3() {
        return ztyyobiv9x3;
    }

    public void setZtyyobiv9x3(String pZtyyobiv9x3) {
        ztyyobiv9x3 = pZtyyobiv9x3;
    }

    private String ztysisuubbncalckijyunymdx4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX4)
    public String getZtysisuubbncalckijyunymdx4() {
        return ztysisuubbncalckijyunymdx4;
    }

    public void setZtysisuubbncalckijyunymdx4(String pZtysisuubbncalckijyunymdx4) {
        ztysisuubbncalckijyunymdx4 = pZtysisuubbncalckijyunymdx4;
    }

    private Long ztysisuubbntumitatekinx4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX4)
    public Long getZtysisuubbntumitatekinx4() {
        return ztysisuubbntumitatekinx4;
    }

    public void setZtysisuubbntumitatekinx4(Long pZtysisuubbntumitatekinx4) {
        ztysisuubbntumitatekinx4 = pZtysisuubbntumitatekinx4;
    }

    private BizNumber ztytoukisisuux4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX4)
    public BizNumber getZtytoukisisuux4() {
        return ztytoukisisuux4;
    }

    public void setZtytoukisisuux4(BizNumber pZtytoukisisuux4) {
        ztytoukisisuux4 = pZtytoukisisuux4;
    }

    private String ztytoukisisuukijyunymdx4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX4)
    public String getZtytoukisisuukijyunymdx4() {
        return ztytoukisisuukijyunymdx4;
    }

    public void setZtytoukisisuukijyunymdx4(String pZtytoukisisuukijyunymdx4) {
        ztytoukisisuukijyunymdx4 = pZtytoukisisuukijyunymdx4;
    }

    private BizNumber ztyzenkisisuux4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX4)
    public BizNumber getZtyzenkisisuux4() {
        return ztyzenkisisuux4;
    }

    public void setZtyzenkisisuux4(BizNumber pZtyzenkisisuux4) {
        ztyzenkisisuux4 = pZtyzenkisisuux4;
    }

    private String ztyzenkisisuukijyunymdx4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX4)
    public String getZtyzenkisisuukijyunymdx4() {
        return ztyzenkisisuukijyunymdx4;
    }

    public void setZtyzenkisisuukijyunymdx4(String pZtyzenkisisuukijyunymdx4) {
        ztyzenkisisuukijyunymdx4 = pZtyzenkisisuukijyunymdx4;
    }

    private BizNumber ztytmttknzoukaritux4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX4)
    public BizNumber getZtytmttknzoukaritux4() {
        return ztytmttknzoukaritux4;
    }

    public void setZtytmttknzoukaritux4(BizNumber pZtytmttknzoukaritux4) {
        ztytmttknzoukaritux4 = pZtytmttknzoukaritux4;
    }

    private Long ztytoukitumimasikinx4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX4)
    public Long getZtytoukitumimasikinx4() {
        return ztytoukitumimasikinx4;
    }

    public void setZtytoukitumimasikinx4(Long pZtytoukitumimasikinx4) {
        ztytoukitumimasikinx4 = pZtytoukitumimasikinx4;
    }

    private String ztyyobiv9x4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X4)
    public String getZtyyobiv9x4() {
        return ztyyobiv9x4;
    }

    public void setZtyyobiv9x4(String pZtyyobiv9x4) {
        ztyyobiv9x4 = pZtyyobiv9x4;
    }

    private String ztysisuubbncalckijyunymdx5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX5)
    public String getZtysisuubbncalckijyunymdx5() {
        return ztysisuubbncalckijyunymdx5;
    }

    public void setZtysisuubbncalckijyunymdx5(String pZtysisuubbncalckijyunymdx5) {
        ztysisuubbncalckijyunymdx5 = pZtysisuubbncalckijyunymdx5;
    }

    private Long ztysisuubbntumitatekinx5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX5)
    public Long getZtysisuubbntumitatekinx5() {
        return ztysisuubbntumitatekinx5;
    }

    public void setZtysisuubbntumitatekinx5(Long pZtysisuubbntumitatekinx5) {
        ztysisuubbntumitatekinx5 = pZtysisuubbntumitatekinx5;
    }

    private BizNumber ztytoukisisuux5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX5)
    public BizNumber getZtytoukisisuux5() {
        return ztytoukisisuux5;
    }

    public void setZtytoukisisuux5(BizNumber pZtytoukisisuux5) {
        ztytoukisisuux5 = pZtytoukisisuux5;
    }

    private String ztytoukisisuukijyunymdx5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX5)
    public String getZtytoukisisuukijyunymdx5() {
        return ztytoukisisuukijyunymdx5;
    }

    public void setZtytoukisisuukijyunymdx5(String pZtytoukisisuukijyunymdx5) {
        ztytoukisisuukijyunymdx5 = pZtytoukisisuukijyunymdx5;
    }

    private BizNumber ztyzenkisisuux5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX5)
    public BizNumber getZtyzenkisisuux5() {
        return ztyzenkisisuux5;
    }

    public void setZtyzenkisisuux5(BizNumber pZtyzenkisisuux5) {
        ztyzenkisisuux5 = pZtyzenkisisuux5;
    }

    private String ztyzenkisisuukijyunymdx5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX5)
    public String getZtyzenkisisuukijyunymdx5() {
        return ztyzenkisisuukijyunymdx5;
    }

    public void setZtyzenkisisuukijyunymdx5(String pZtyzenkisisuukijyunymdx5) {
        ztyzenkisisuukijyunymdx5 = pZtyzenkisisuukijyunymdx5;
    }

    private BizNumber ztytmttknzoukaritux5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX5)
    public BizNumber getZtytmttknzoukaritux5() {
        return ztytmttknzoukaritux5;
    }

    public void setZtytmttknzoukaritux5(BizNumber pZtytmttknzoukaritux5) {
        ztytmttknzoukaritux5 = pZtytmttknzoukaritux5;
    }

    private Long ztytoukitumimasikinx5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX5)
    public Long getZtytoukitumimasikinx5() {
        return ztytoukitumimasikinx5;
    }

    public void setZtytoukitumimasikinx5(Long pZtytoukitumimasikinx5) {
        ztytoukitumimasikinx5 = pZtytoukitumimasikinx5;
    }

    private String ztyyobiv9x5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X5)
    public String getZtyyobiv9x5() {
        return ztyyobiv9x5;
    }

    public void setZtyyobiv9x5(String pZtyyobiv9x5) {
        ztyyobiv9x5 = pZtyyobiv9x5;
    }

    private String ztysisuubbncalckijyunymdx6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX6)
    public String getZtysisuubbncalckijyunymdx6() {
        return ztysisuubbncalckijyunymdx6;
    }

    public void setZtysisuubbncalckijyunymdx6(String pZtysisuubbncalckijyunymdx6) {
        ztysisuubbncalckijyunymdx6 = pZtysisuubbncalckijyunymdx6;
    }

    private Long ztysisuubbntumitatekinx6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX6)
    public Long getZtysisuubbntumitatekinx6() {
        return ztysisuubbntumitatekinx6;
    }

    public void setZtysisuubbntumitatekinx6(Long pZtysisuubbntumitatekinx6) {
        ztysisuubbntumitatekinx6 = pZtysisuubbntumitatekinx6;
    }

    private BizNumber ztytoukisisuux6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX6)
    public BizNumber getZtytoukisisuux6() {
        return ztytoukisisuux6;
    }

    public void setZtytoukisisuux6(BizNumber pZtytoukisisuux6) {
        ztytoukisisuux6 = pZtytoukisisuux6;
    }

    private String ztytoukisisuukijyunymdx6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX6)
    public String getZtytoukisisuukijyunymdx6() {
        return ztytoukisisuukijyunymdx6;
    }

    public void setZtytoukisisuukijyunymdx6(String pZtytoukisisuukijyunymdx6) {
        ztytoukisisuukijyunymdx6 = pZtytoukisisuukijyunymdx6;
    }

    private BizNumber ztyzenkisisuux6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX6)
    public BizNumber getZtyzenkisisuux6() {
        return ztyzenkisisuux6;
    }

    public void setZtyzenkisisuux6(BizNumber pZtyzenkisisuux6) {
        ztyzenkisisuux6 = pZtyzenkisisuux6;
    }

    private String ztyzenkisisuukijyunymdx6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX6)
    public String getZtyzenkisisuukijyunymdx6() {
        return ztyzenkisisuukijyunymdx6;
    }

    public void setZtyzenkisisuukijyunymdx6(String pZtyzenkisisuukijyunymdx6) {
        ztyzenkisisuukijyunymdx6 = pZtyzenkisisuukijyunymdx6;
    }

    private BizNumber ztytmttknzoukaritux6;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX6)
    public BizNumber getZtytmttknzoukaritux6() {
        return ztytmttknzoukaritux6;
    }

    public void setZtytmttknzoukaritux6(BizNumber pZtytmttknzoukaritux6) {
        ztytmttknzoukaritux6 = pZtytmttknzoukaritux6;
    }

    private Long ztytoukitumimasikinx6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX6)
    public Long getZtytoukitumimasikinx6() {
        return ztytoukitumimasikinx6;
    }

    public void setZtytoukitumimasikinx6(Long pZtytoukitumimasikinx6) {
        ztytoukitumimasikinx6 = pZtytoukitumimasikinx6;
    }

    private String ztyyobiv9x6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X6)
    public String getZtyyobiv9x6() {
        return ztyyobiv9x6;
    }

    public void setZtyyobiv9x6(String pZtyyobiv9x6) {
        ztyyobiv9x6 = pZtyyobiv9x6;
    }

    private String ztysisuubbncalckijyunymdx7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX7)
    public String getZtysisuubbncalckijyunymdx7() {
        return ztysisuubbncalckijyunymdx7;
    }

    public void setZtysisuubbncalckijyunymdx7(String pZtysisuubbncalckijyunymdx7) {
        ztysisuubbncalckijyunymdx7 = pZtysisuubbncalckijyunymdx7;
    }

    private Long ztysisuubbntumitatekinx7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX7)
    public Long getZtysisuubbntumitatekinx7() {
        return ztysisuubbntumitatekinx7;
    }

    public void setZtysisuubbntumitatekinx7(Long pZtysisuubbntumitatekinx7) {
        ztysisuubbntumitatekinx7 = pZtysisuubbntumitatekinx7;
    }

    private BizNumber ztytoukisisuux7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX7)
    public BizNumber getZtytoukisisuux7() {
        return ztytoukisisuux7;
    }

    public void setZtytoukisisuux7(BizNumber pZtytoukisisuux7) {
        ztytoukisisuux7 = pZtytoukisisuux7;
    }

    private String ztytoukisisuukijyunymdx7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX7)
    public String getZtytoukisisuukijyunymdx7() {
        return ztytoukisisuukijyunymdx7;
    }

    public void setZtytoukisisuukijyunymdx7(String pZtytoukisisuukijyunymdx7) {
        ztytoukisisuukijyunymdx7 = pZtytoukisisuukijyunymdx7;
    }

    private BizNumber ztyzenkisisuux7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX7)
    public BizNumber getZtyzenkisisuux7() {
        return ztyzenkisisuux7;
    }

    public void setZtyzenkisisuux7(BizNumber pZtyzenkisisuux7) {
        ztyzenkisisuux7 = pZtyzenkisisuux7;
    }

    private String ztyzenkisisuukijyunymdx7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX7)
    public String getZtyzenkisisuukijyunymdx7() {
        return ztyzenkisisuukijyunymdx7;
    }

    public void setZtyzenkisisuukijyunymdx7(String pZtyzenkisisuukijyunymdx7) {
        ztyzenkisisuukijyunymdx7 = pZtyzenkisisuukijyunymdx7;
    }

    private BizNumber ztytmttknzoukaritux7;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX7)
    public BizNumber getZtytmttknzoukaritux7() {
        return ztytmttknzoukaritux7;
    }

    public void setZtytmttknzoukaritux7(BizNumber pZtytmttknzoukaritux7) {
        ztytmttknzoukaritux7 = pZtytmttknzoukaritux7;
    }

    private Long ztytoukitumimasikinx7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX7)
    public Long getZtytoukitumimasikinx7() {
        return ztytoukitumimasikinx7;
    }

    public void setZtytoukitumimasikinx7(Long pZtytoukitumimasikinx7) {
        ztytoukitumimasikinx7 = pZtytoukitumimasikinx7;
    }

    private String ztyyobiv9x7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X7)
    public String getZtyyobiv9x7() {
        return ztyyobiv9x7;
    }

    public void setZtyyobiv9x7(String pZtyyobiv9x7) {
        ztyyobiv9x7 = pZtyyobiv9x7;
    }

    private String ztysisuubbncalckijyunymdx8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX8)
    public String getZtysisuubbncalckijyunymdx8() {
        return ztysisuubbncalckijyunymdx8;
    }

    public void setZtysisuubbncalckijyunymdx8(String pZtysisuubbncalckijyunymdx8) {
        ztysisuubbncalckijyunymdx8 = pZtysisuubbncalckijyunymdx8;
    }

    private Long ztysisuubbntumitatekinx8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX8)
    public Long getZtysisuubbntumitatekinx8() {
        return ztysisuubbntumitatekinx8;
    }

    public void setZtysisuubbntumitatekinx8(Long pZtysisuubbntumitatekinx8) {
        ztysisuubbntumitatekinx8 = pZtysisuubbntumitatekinx8;
    }

    private BizNumber ztytoukisisuux8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX8)
    public BizNumber getZtytoukisisuux8() {
        return ztytoukisisuux8;
    }

    public void setZtytoukisisuux8(BizNumber pZtytoukisisuux8) {
        ztytoukisisuux8 = pZtytoukisisuux8;
    }

    private String ztytoukisisuukijyunymdx8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX8)
    public String getZtytoukisisuukijyunymdx8() {
        return ztytoukisisuukijyunymdx8;
    }

    public void setZtytoukisisuukijyunymdx8(String pZtytoukisisuukijyunymdx8) {
        ztytoukisisuukijyunymdx8 = pZtytoukisisuukijyunymdx8;
    }

    private BizNumber ztyzenkisisuux8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX8)
    public BizNumber getZtyzenkisisuux8() {
        return ztyzenkisisuux8;
    }

    public void setZtyzenkisisuux8(BizNumber pZtyzenkisisuux8) {
        ztyzenkisisuux8 = pZtyzenkisisuux8;
    }

    private String ztyzenkisisuukijyunymdx8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX8)
    public String getZtyzenkisisuukijyunymdx8() {
        return ztyzenkisisuukijyunymdx8;
    }

    public void setZtyzenkisisuukijyunymdx8(String pZtyzenkisisuukijyunymdx8) {
        ztyzenkisisuukijyunymdx8 = pZtyzenkisisuukijyunymdx8;
    }

    private BizNumber ztytmttknzoukaritux8;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX8)
    public BizNumber getZtytmttknzoukaritux8() {
        return ztytmttknzoukaritux8;
    }

    public void setZtytmttknzoukaritux8(BizNumber pZtytmttknzoukaritux8) {
        ztytmttknzoukaritux8 = pZtytmttknzoukaritux8;
    }

    private Long ztytoukitumimasikinx8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX8)
    public Long getZtytoukitumimasikinx8() {
        return ztytoukitumimasikinx8;
    }

    public void setZtytoukitumimasikinx8(Long pZtytoukitumimasikinx8) {
        ztytoukitumimasikinx8 = pZtytoukitumimasikinx8;
    }

    private String ztyyobiv9x8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X8)
    public String getZtyyobiv9x8() {
        return ztyyobiv9x8;
    }

    public void setZtyyobiv9x8(String pZtyyobiv9x8) {
        ztyyobiv9x8 = pZtyyobiv9x8;
    }

    private String ztysisuubbncalckijyunymdx9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX9)
    public String getZtysisuubbncalckijyunymdx9() {
        return ztysisuubbncalckijyunymdx9;
    }

    public void setZtysisuubbncalckijyunymdx9(String pZtysisuubbncalckijyunymdx9) {
        ztysisuubbncalckijyunymdx9 = pZtysisuubbncalckijyunymdx9;
    }

    private Long ztysisuubbntumitatekinx9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX9)
    public Long getZtysisuubbntumitatekinx9() {
        return ztysisuubbntumitatekinx9;
    }

    public void setZtysisuubbntumitatekinx9(Long pZtysisuubbntumitatekinx9) {
        ztysisuubbntumitatekinx9 = pZtysisuubbntumitatekinx9;
    }

    private BizNumber ztytoukisisuux9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX9)
    public BizNumber getZtytoukisisuux9() {
        return ztytoukisisuux9;
    }

    public void setZtytoukisisuux9(BizNumber pZtytoukisisuux9) {
        ztytoukisisuux9 = pZtytoukisisuux9;
    }

    private String ztytoukisisuukijyunymdx9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX9)
    public String getZtytoukisisuukijyunymdx9() {
        return ztytoukisisuukijyunymdx9;
    }

    public void setZtytoukisisuukijyunymdx9(String pZtytoukisisuukijyunymdx9) {
        ztytoukisisuukijyunymdx9 = pZtytoukisisuukijyunymdx9;
    }

    private BizNumber ztyzenkisisuux9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX9)
    public BizNumber getZtyzenkisisuux9() {
        return ztyzenkisisuux9;
    }

    public void setZtyzenkisisuux9(BizNumber pZtyzenkisisuux9) {
        ztyzenkisisuux9 = pZtyzenkisisuux9;
    }

    private String ztyzenkisisuukijyunymdx9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX9)
    public String getZtyzenkisisuukijyunymdx9() {
        return ztyzenkisisuukijyunymdx9;
    }

    public void setZtyzenkisisuukijyunymdx9(String pZtyzenkisisuukijyunymdx9) {
        ztyzenkisisuukijyunymdx9 = pZtyzenkisisuukijyunymdx9;
    }

    private BizNumber ztytmttknzoukaritux9;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX9)
    public BizNumber getZtytmttknzoukaritux9() {
        return ztytmttknzoukaritux9;
    }

    public void setZtytmttknzoukaritux9(BizNumber pZtytmttknzoukaritux9) {
        ztytmttknzoukaritux9 = pZtytmttknzoukaritux9;
    }

    private Long ztytoukitumimasikinx9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX9)
    public Long getZtytoukitumimasikinx9() {
        return ztytoukitumimasikinx9;
    }

    public void setZtytoukitumimasikinx9(Long pZtytoukitumimasikinx9) {
        ztytoukitumimasikinx9 = pZtytoukitumimasikinx9;
    }

    private String ztyyobiv9x9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X9)
    public String getZtyyobiv9x9() {
        return ztyyobiv9x9;
    }

    public void setZtyyobiv9x9(String pZtyyobiv9x9) {
        ztyyobiv9x9 = pZtyyobiv9x9;
    }

    private String ztysisuubbncalckijyunymdx10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX10)
    public String getZtysisuubbncalckijyunymdx10() {
        return ztysisuubbncalckijyunymdx10;
    }

    public void setZtysisuubbncalckijyunymdx10(String pZtysisuubbncalckijyunymdx10) {
        ztysisuubbncalckijyunymdx10 = pZtysisuubbncalckijyunymdx10;
    }

    private Long ztysisuubbntumitatekinx10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX10)
    public Long getZtysisuubbntumitatekinx10() {
        return ztysisuubbntumitatekinx10;
    }

    public void setZtysisuubbntumitatekinx10(Long pZtysisuubbntumitatekinx10) {
        ztysisuubbntumitatekinx10 = pZtysisuubbntumitatekinx10;
    }

    private BizNumber ztytoukisisuux10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX10)
    public BizNumber getZtytoukisisuux10() {
        return ztytoukisisuux10;
    }

    public void setZtytoukisisuux10(BizNumber pZtytoukisisuux10) {
        ztytoukisisuux10 = pZtytoukisisuux10;
    }

    private String ztytoukisisuukijyunymdx10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX10)
    public String getZtytoukisisuukijyunymdx10() {
        return ztytoukisisuukijyunymdx10;
    }

    public void setZtytoukisisuukijyunymdx10(String pZtytoukisisuukijyunymdx10) {
        ztytoukisisuukijyunymdx10 = pZtytoukisisuukijyunymdx10;
    }

    private BizNumber ztyzenkisisuux10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX10)
    public BizNumber getZtyzenkisisuux10() {
        return ztyzenkisisuux10;
    }

    public void setZtyzenkisisuux10(BizNumber pZtyzenkisisuux10) {
        ztyzenkisisuux10 = pZtyzenkisisuux10;
    }

    private String ztyzenkisisuukijyunymdx10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX10)
    public String getZtyzenkisisuukijyunymdx10() {
        return ztyzenkisisuukijyunymdx10;
    }

    public void setZtyzenkisisuukijyunymdx10(String pZtyzenkisisuukijyunymdx10) {
        ztyzenkisisuukijyunymdx10 = pZtyzenkisisuukijyunymdx10;
    }

    private BizNumber ztytmttknzoukaritux10;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX10)
    public BizNumber getZtytmttknzoukaritux10() {
        return ztytmttknzoukaritux10;
    }

    public void setZtytmttknzoukaritux10(BizNumber pZtytmttknzoukaritux10) {
        ztytmttknzoukaritux10 = pZtytmttknzoukaritux10;
    }

    private Long ztytoukitumimasikinx10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX10)
    public Long getZtytoukitumimasikinx10() {
        return ztytoukitumimasikinx10;
    }

    public void setZtytoukitumimasikinx10(Long pZtytoukitumimasikinx10) {
        ztytoukitumimasikinx10 = pZtytoukitumimasikinx10;
    }

    private String ztyyobiv9x10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X10)
    public String getZtyyobiv9x10() {
        return ztyyobiv9x10;
    }

    public void setZtyyobiv9x10(String pZtyyobiv9x10) {
        ztyyobiv9x10 = pZtyyobiv9x10;
    }

    private String ztysisuubbncalckijyunymdx11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX11)
    public String getZtysisuubbncalckijyunymdx11() {
        return ztysisuubbncalckijyunymdx11;
    }

    public void setZtysisuubbncalckijyunymdx11(String pZtysisuubbncalckijyunymdx11) {
        ztysisuubbncalckijyunymdx11 = pZtysisuubbncalckijyunymdx11;
    }

    private Long ztysisuubbntumitatekinx11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX11)
    public Long getZtysisuubbntumitatekinx11() {
        return ztysisuubbntumitatekinx11;
    }

    public void setZtysisuubbntumitatekinx11(Long pZtysisuubbntumitatekinx11) {
        ztysisuubbntumitatekinx11 = pZtysisuubbntumitatekinx11;
    }

    private BizNumber ztytoukisisuux11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX11)
    public BizNumber getZtytoukisisuux11() {
        return ztytoukisisuux11;
    }

    public void setZtytoukisisuux11(BizNumber pZtytoukisisuux11) {
        ztytoukisisuux11 = pZtytoukisisuux11;
    }

    private String ztytoukisisuukijyunymdx11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX11)
    public String getZtytoukisisuukijyunymdx11() {
        return ztytoukisisuukijyunymdx11;
    }

    public void setZtytoukisisuukijyunymdx11(String pZtytoukisisuukijyunymdx11) {
        ztytoukisisuukijyunymdx11 = pZtytoukisisuukijyunymdx11;
    }

    private BizNumber ztyzenkisisuux11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX11)
    public BizNumber getZtyzenkisisuux11() {
        return ztyzenkisisuux11;
    }

    public void setZtyzenkisisuux11(BizNumber pZtyzenkisisuux11) {
        ztyzenkisisuux11 = pZtyzenkisisuux11;
    }

    private String ztyzenkisisuukijyunymdx11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX11)
    public String getZtyzenkisisuukijyunymdx11() {
        return ztyzenkisisuukijyunymdx11;
    }

    public void setZtyzenkisisuukijyunymdx11(String pZtyzenkisisuukijyunymdx11) {
        ztyzenkisisuukijyunymdx11 = pZtyzenkisisuukijyunymdx11;
    }

    private BizNumber ztytmttknzoukaritux11;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX11)
    public BizNumber getZtytmttknzoukaritux11() {
        return ztytmttknzoukaritux11;
    }

    public void setZtytmttknzoukaritux11(BizNumber pZtytmttknzoukaritux11) {
        ztytmttknzoukaritux11 = pZtytmttknzoukaritux11;
    }

    private Long ztytoukitumimasikinx11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX11)
    public Long getZtytoukitumimasikinx11() {
        return ztytoukitumimasikinx11;
    }

    public void setZtytoukitumimasikinx11(Long pZtytoukitumimasikinx11) {
        ztytoukitumimasikinx11 = pZtytoukitumimasikinx11;
    }

    private String ztyyobiv9x11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X11)
    public String getZtyyobiv9x11() {
        return ztyyobiv9x11;
    }

    public void setZtyyobiv9x11(String pZtyyobiv9x11) {
        ztyyobiv9x11 = pZtyyobiv9x11;
    }

    private String ztysisuubbncalckijyunymdx12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX12)
    public String getZtysisuubbncalckijyunymdx12() {
        return ztysisuubbncalckijyunymdx12;
    }

    public void setZtysisuubbncalckijyunymdx12(String pZtysisuubbncalckijyunymdx12) {
        ztysisuubbncalckijyunymdx12 = pZtysisuubbncalckijyunymdx12;
    }

    private Long ztysisuubbntumitatekinx12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX12)
    public Long getZtysisuubbntumitatekinx12() {
        return ztysisuubbntumitatekinx12;
    }

    public void setZtysisuubbntumitatekinx12(Long pZtysisuubbntumitatekinx12) {
        ztysisuubbntumitatekinx12 = pZtysisuubbntumitatekinx12;
    }

    private BizNumber ztytoukisisuux12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX12)
    public BizNumber getZtytoukisisuux12() {
        return ztytoukisisuux12;
    }

    public void setZtytoukisisuux12(BizNumber pZtytoukisisuux12) {
        ztytoukisisuux12 = pZtytoukisisuux12;
    }

    private String ztytoukisisuukijyunymdx12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX12)
    public String getZtytoukisisuukijyunymdx12() {
        return ztytoukisisuukijyunymdx12;
    }

    public void setZtytoukisisuukijyunymdx12(String pZtytoukisisuukijyunymdx12) {
        ztytoukisisuukijyunymdx12 = pZtytoukisisuukijyunymdx12;
    }

    private BizNumber ztyzenkisisuux12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX12)
    public BizNumber getZtyzenkisisuux12() {
        return ztyzenkisisuux12;
    }

    public void setZtyzenkisisuux12(BizNumber pZtyzenkisisuux12) {
        ztyzenkisisuux12 = pZtyzenkisisuux12;
    }

    private String ztyzenkisisuukijyunymdx12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX12)
    public String getZtyzenkisisuukijyunymdx12() {
        return ztyzenkisisuukijyunymdx12;
    }

    public void setZtyzenkisisuukijyunymdx12(String pZtyzenkisisuukijyunymdx12) {
        ztyzenkisisuukijyunymdx12 = pZtyzenkisisuukijyunymdx12;
    }

    private BizNumber ztytmttknzoukaritux12;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX12)
    public BizNumber getZtytmttknzoukaritux12() {
        return ztytmttknzoukaritux12;
    }

    public void setZtytmttknzoukaritux12(BizNumber pZtytmttknzoukaritux12) {
        ztytmttknzoukaritux12 = pZtytmttknzoukaritux12;
    }

    private Long ztytoukitumimasikinx12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX12)
    public Long getZtytoukitumimasikinx12() {
        return ztytoukitumimasikinx12;
    }

    public void setZtytoukitumimasikinx12(Long pZtytoukitumimasikinx12) {
        ztytoukitumimasikinx12 = pZtytoukitumimasikinx12;
    }

    private String ztyyobiv9x12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X12)
    public String getZtyyobiv9x12() {
        return ztyyobiv9x12;
    }

    public void setZtyyobiv9x12(String pZtyyobiv9x12) {
        ztyyobiv9x12 = pZtyyobiv9x12;
    }

    private String ztysisuubbncalckijyunymdx13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX13)
    public String getZtysisuubbncalckijyunymdx13() {
        return ztysisuubbncalckijyunymdx13;
    }

    public void setZtysisuubbncalckijyunymdx13(String pZtysisuubbncalckijyunymdx13) {
        ztysisuubbncalckijyunymdx13 = pZtysisuubbncalckijyunymdx13;
    }

    private Long ztysisuubbntumitatekinx13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX13)
    public Long getZtysisuubbntumitatekinx13() {
        return ztysisuubbntumitatekinx13;
    }

    public void setZtysisuubbntumitatekinx13(Long pZtysisuubbntumitatekinx13) {
        ztysisuubbntumitatekinx13 = pZtysisuubbntumitatekinx13;
    }

    private BizNumber ztytoukisisuux13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX13)
    public BizNumber getZtytoukisisuux13() {
        return ztytoukisisuux13;
    }

    public void setZtytoukisisuux13(BizNumber pZtytoukisisuux13) {
        ztytoukisisuux13 = pZtytoukisisuux13;
    }

    private String ztytoukisisuukijyunymdx13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX13)
    public String getZtytoukisisuukijyunymdx13() {
        return ztytoukisisuukijyunymdx13;
    }

    public void setZtytoukisisuukijyunymdx13(String pZtytoukisisuukijyunymdx13) {
        ztytoukisisuukijyunymdx13 = pZtytoukisisuukijyunymdx13;
    }

    private BizNumber ztyzenkisisuux13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX13)
    public BizNumber getZtyzenkisisuux13() {
        return ztyzenkisisuux13;
    }

    public void setZtyzenkisisuux13(BizNumber pZtyzenkisisuux13) {
        ztyzenkisisuux13 = pZtyzenkisisuux13;
    }

    private String ztyzenkisisuukijyunymdx13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX13)
    public String getZtyzenkisisuukijyunymdx13() {
        return ztyzenkisisuukijyunymdx13;
    }

    public void setZtyzenkisisuukijyunymdx13(String pZtyzenkisisuukijyunymdx13) {
        ztyzenkisisuukijyunymdx13 = pZtyzenkisisuukijyunymdx13;
    }

    private BizNumber ztytmttknzoukaritux13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX13)
    public BizNumber getZtytmttknzoukaritux13() {
        return ztytmttknzoukaritux13;
    }

    public void setZtytmttknzoukaritux13(BizNumber pZtytmttknzoukaritux13) {
        ztytmttknzoukaritux13 = pZtytmttknzoukaritux13;
    }

    private Long ztytoukitumimasikinx13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX13)
    public Long getZtytoukitumimasikinx13() {
        return ztytoukitumimasikinx13;
    }

    public void setZtytoukitumimasikinx13(Long pZtytoukitumimasikinx13) {
        ztytoukitumimasikinx13 = pZtytoukitumimasikinx13;
    }

    private String ztyyobiv9x13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X13)
    public String getZtyyobiv9x13() {
        return ztyyobiv9x13;
    }

    public void setZtyyobiv9x13(String pZtyyobiv9x13) {
        ztyyobiv9x13 = pZtyyobiv9x13;
    }

    private String ztysisuubbncalckijyunymdx14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX14)
    public String getZtysisuubbncalckijyunymdx14() {
        return ztysisuubbncalckijyunymdx14;
    }

    public void setZtysisuubbncalckijyunymdx14(String pZtysisuubbncalckijyunymdx14) {
        ztysisuubbncalckijyunymdx14 = pZtysisuubbncalckijyunymdx14;
    }

    private Long ztysisuubbntumitatekinx14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX14)
    public Long getZtysisuubbntumitatekinx14() {
        return ztysisuubbntumitatekinx14;
    }

    public void setZtysisuubbntumitatekinx14(Long pZtysisuubbntumitatekinx14) {
        ztysisuubbntumitatekinx14 = pZtysisuubbntumitatekinx14;
    }

    private BizNumber ztytoukisisuux14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX14)
    public BizNumber getZtytoukisisuux14() {
        return ztytoukisisuux14;
    }

    public void setZtytoukisisuux14(BizNumber pZtytoukisisuux14) {
        ztytoukisisuux14 = pZtytoukisisuux14;
    }

    private String ztytoukisisuukijyunymdx14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX14)
    public String getZtytoukisisuukijyunymdx14() {
        return ztytoukisisuukijyunymdx14;
    }

    public void setZtytoukisisuukijyunymdx14(String pZtytoukisisuukijyunymdx14) {
        ztytoukisisuukijyunymdx14 = pZtytoukisisuukijyunymdx14;
    }

    private BizNumber ztyzenkisisuux14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX14)
    public BizNumber getZtyzenkisisuux14() {
        return ztyzenkisisuux14;
    }

    public void setZtyzenkisisuux14(BizNumber pZtyzenkisisuux14) {
        ztyzenkisisuux14 = pZtyzenkisisuux14;
    }

    private String ztyzenkisisuukijyunymdx14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX14)
    public String getZtyzenkisisuukijyunymdx14() {
        return ztyzenkisisuukijyunymdx14;
    }

    public void setZtyzenkisisuukijyunymdx14(String pZtyzenkisisuukijyunymdx14) {
        ztyzenkisisuukijyunymdx14 = pZtyzenkisisuukijyunymdx14;
    }

    private BizNumber ztytmttknzoukaritux14;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX14)
    public BizNumber getZtytmttknzoukaritux14() {
        return ztytmttknzoukaritux14;
    }

    public void setZtytmttknzoukaritux14(BizNumber pZtytmttknzoukaritux14) {
        ztytmttknzoukaritux14 = pZtytmttknzoukaritux14;
    }

    private Long ztytoukitumimasikinx14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX14)
    public Long getZtytoukitumimasikinx14() {
        return ztytoukitumimasikinx14;
    }

    public void setZtytoukitumimasikinx14(Long pZtytoukitumimasikinx14) {
        ztytoukitumimasikinx14 = pZtytoukitumimasikinx14;
    }

    private String ztyyobiv9x14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X14)
    public String getZtyyobiv9x14() {
        return ztyyobiv9x14;
    }

    public void setZtyyobiv9x14(String pZtyyobiv9x14) {
        ztyyobiv9x14 = pZtyyobiv9x14;
    }

    private String ztysisuubbncalckijyunymdx15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNCALCKIJYUNYMDX15)
    public String getZtysisuubbncalckijyunymdx15() {
        return ztysisuubbncalckijyunymdx15;
    }

    public void setZtysisuubbncalckijyunymdx15(String pZtysisuubbncalckijyunymdx15) {
        ztysisuubbncalckijyunymdx15 = pZtysisuubbncalckijyunymdx15;
    }

    private Long ztysisuubbntumitatekinx15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSISUUBBNTUMITATEKINX15)
    public Long getZtysisuubbntumitatekinx15() {
        return ztysisuubbntumitatekinx15;
    }

    public void setZtysisuubbntumitatekinx15(Long pZtysisuubbntumitatekinx15) {
        ztysisuubbntumitatekinx15 = pZtysisuubbntumitatekinx15;
    }

    private BizNumber ztytoukisisuux15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUX15)
    public BizNumber getZtytoukisisuux15() {
        return ztytoukisisuux15;
    }

    public void setZtytoukisisuux15(BizNumber pZtytoukisisuux15) {
        ztytoukisisuux15 = pZtytoukisisuux15;
    }

    private String ztytoukisisuukijyunymdx15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKISISUUKIJYUNYMDX15)
    public String getZtytoukisisuukijyunymdx15() {
        return ztytoukisisuukijyunymdx15;
    }

    public void setZtytoukisisuukijyunymdx15(String pZtytoukisisuukijyunymdx15) {
        ztytoukisisuukijyunymdx15 = pZtytoukisisuukijyunymdx15;
    }

    private BizNumber ztyzenkisisuux15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUX15)
    public BizNumber getZtyzenkisisuux15() {
        return ztyzenkisisuux15;
    }

    public void setZtyzenkisisuux15(BizNumber pZtyzenkisisuux15) {
        ztyzenkisisuux15 = pZtyzenkisisuux15;
    }

    private String ztyzenkisisuukijyunymdx15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYZENKISISUUKIJYUNYMDX15)
    public String getZtyzenkisisuukijyunymdx15() {
        return ztyzenkisisuukijyunymdx15;
    }

    public void setZtyzenkisisuukijyunymdx15(String pZtyzenkisisuukijyunymdx15) {
        ztyzenkisisuukijyunymdx15 = pZtyzenkisisuukijyunymdx15;
    }

    private BizNumber ztytmttknzoukaritux15;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTMTTKNZOUKARITUX15)
    public BizNumber getZtytmttknzoukaritux15() {
        return ztytmttknzoukaritux15;
    }

    public void setZtytmttknzoukaritux15(BizNumber pZtytmttknzoukaritux15) {
        ztytmttknzoukaritux15 = pZtytmttknzoukaritux15;
    }

    private Long ztytoukitumimasikinx15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTOUKITUMIMASIKINX15)
    public Long getZtytoukitumimasikinx15() {
        return ztytoukitumimasikinx15;
    }

    public void setZtytoukitumimasikinx15(Long pZtytoukitumimasikinx15) {
        ztytoukitumimasikinx15 = pZtytoukitumimasikinx15;
    }

    private String ztyyobiv9x15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV9X15)
    public String getZtyyobiv9x15() {
        return ztyyobiv9x15;
    }

    public void setZtyyobiv9x15(String pZtyyobiv9x15) {
        ztyyobiv9x15 = pZtyyobiv9x15;
    }

    private String ztyteiritucalckijyunymd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMD)
    public String getZtyteiritucalckijyunymd() {
        return ztyteiritucalckijyunymd;
    }

    public void setZtyteiritucalckijyunymd(String pZtyteiritucalckijyunymd) {
        ztyteiritucalckijyunymd = pZtyteiritucalckijyunymd;
    }

    private Long ztyteiritutumitatekin;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKIN)
    public Long getZtyteiritutumitatekin() {
        return ztyteiritutumitatekin;
    }

    public void setZtyteiritutumitatekin(Long pZtyteiritutumitatekin) {
        ztyteiritutumitatekin = pZtyteiritutumitatekin;
    }

    private String ztyyobiv16;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16)
    public String getZtyyobiv16() {
        return ztyyobiv16;
    }

    public void setZtyyobiv16(String pZtyyobiv16) {
        ztyyobiv16 = pZtyyobiv16;
    }

    private String ztyteiritucalckijyunymdx2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX2)
    public String getZtyteiritucalckijyunymdx2() {
        return ztyteiritucalckijyunymdx2;
    }

    public void setZtyteiritucalckijyunymdx2(String pZtyteiritucalckijyunymdx2) {
        ztyteiritucalckijyunymdx2 = pZtyteiritucalckijyunymdx2;
    }

    private Long ztyteiritutumitatekinx2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX2)
    public Long getZtyteiritutumitatekinx2() {
        return ztyteiritutumitatekinx2;
    }

    public void setZtyteiritutumitatekinx2(Long pZtyteiritutumitatekinx2) {
        ztyteiritutumitatekinx2 = pZtyteiritutumitatekinx2;
    }

    private String ztyyobiv16x2;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X2)
    public String getZtyyobiv16x2() {
        return ztyyobiv16x2;
    }

    public void setZtyyobiv16x2(String pZtyyobiv16x2) {
        ztyyobiv16x2 = pZtyyobiv16x2;
    }

    private String ztyteiritucalckijyunymdx3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX3)
    public String getZtyteiritucalckijyunymdx3() {
        return ztyteiritucalckijyunymdx3;
    }

    public void setZtyteiritucalckijyunymdx3(String pZtyteiritucalckijyunymdx3) {
        ztyteiritucalckijyunymdx3 = pZtyteiritucalckijyunymdx3;
    }

    private Long ztyteiritutumitatekinx3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX3)
    public Long getZtyteiritutumitatekinx3() {
        return ztyteiritutumitatekinx3;
    }

    public void setZtyteiritutumitatekinx3(Long pZtyteiritutumitatekinx3) {
        ztyteiritutumitatekinx3 = pZtyteiritutumitatekinx3;
    }

    private String ztyyobiv16x3;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X3)
    public String getZtyyobiv16x3() {
        return ztyyobiv16x3;
    }

    public void setZtyyobiv16x3(String pZtyyobiv16x3) {
        ztyyobiv16x3 = pZtyyobiv16x3;
    }

    private String ztyteiritucalckijyunymdx4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX4)
    public String getZtyteiritucalckijyunymdx4() {
        return ztyteiritucalckijyunymdx4;
    }

    public void setZtyteiritucalckijyunymdx4(String pZtyteiritucalckijyunymdx4) {
        ztyteiritucalckijyunymdx4 = pZtyteiritucalckijyunymdx4;
    }

    private Long ztyteiritutumitatekinx4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX4)
    public Long getZtyteiritutumitatekinx4() {
        return ztyteiritutumitatekinx4;
    }

    public void setZtyteiritutumitatekinx4(Long pZtyteiritutumitatekinx4) {
        ztyteiritutumitatekinx4 = pZtyteiritutumitatekinx4;
    }

    private String ztyyobiv16x4;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X4)
    public String getZtyyobiv16x4() {
        return ztyyobiv16x4;
    }

    public void setZtyyobiv16x4(String pZtyyobiv16x4) {
        ztyyobiv16x4 = pZtyyobiv16x4;
    }

    private String ztyteiritucalckijyunymdx5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX5)
    public String getZtyteiritucalckijyunymdx5() {
        return ztyteiritucalckijyunymdx5;
    }

    public void setZtyteiritucalckijyunymdx5(String pZtyteiritucalckijyunymdx5) {
        ztyteiritucalckijyunymdx5 = pZtyteiritucalckijyunymdx5;
    }

    private Long ztyteiritutumitatekinx5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX5)
    public Long getZtyteiritutumitatekinx5() {
        return ztyteiritutumitatekinx5;
    }

    public void setZtyteiritutumitatekinx5(Long pZtyteiritutumitatekinx5) {
        ztyteiritutumitatekinx5 = pZtyteiritutumitatekinx5;
    }

    private String ztyyobiv16x5;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X5)
    public String getZtyyobiv16x5() {
        return ztyyobiv16x5;
    }

    public void setZtyyobiv16x5(String pZtyyobiv16x5) {
        ztyyobiv16x5 = pZtyyobiv16x5;
    }

    private String ztyteiritucalckijyunymdx6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX6)
    public String getZtyteiritucalckijyunymdx6() {
        return ztyteiritucalckijyunymdx6;
    }

    public void setZtyteiritucalckijyunymdx6(String pZtyteiritucalckijyunymdx6) {
        ztyteiritucalckijyunymdx6 = pZtyteiritucalckijyunymdx6;
    }

    private Long ztyteiritutumitatekinx6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX6)
    public Long getZtyteiritutumitatekinx6() {
        return ztyteiritutumitatekinx6;
    }

    public void setZtyteiritutumitatekinx6(Long pZtyteiritutumitatekinx6) {
        ztyteiritutumitatekinx6 = pZtyteiritutumitatekinx6;
    }

    private String ztyyobiv16x6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X6)
    public String getZtyyobiv16x6() {
        return ztyyobiv16x6;
    }

    public void setZtyyobiv16x6(String pZtyyobiv16x6) {
        ztyyobiv16x6 = pZtyyobiv16x6;
    }

    private String ztyteiritucalckijyunymdx7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX7)
    public String getZtyteiritucalckijyunymdx7() {
        return ztyteiritucalckijyunymdx7;
    }

    public void setZtyteiritucalckijyunymdx7(String pZtyteiritucalckijyunymdx7) {
        ztyteiritucalckijyunymdx7 = pZtyteiritucalckijyunymdx7;
    }

    private Long ztyteiritutumitatekinx7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX7)
    public Long getZtyteiritutumitatekinx7() {
        return ztyteiritutumitatekinx7;
    }

    public void setZtyteiritutumitatekinx7(Long pZtyteiritutumitatekinx7) {
        ztyteiritutumitatekinx7 = pZtyteiritutumitatekinx7;
    }

    private String ztyyobiv16x7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X7)
    public String getZtyyobiv16x7() {
        return ztyyobiv16x7;
    }

    public void setZtyyobiv16x7(String pZtyyobiv16x7) {
        ztyyobiv16x7 = pZtyyobiv16x7;
    }

    private String ztyteiritucalckijyunymdx8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX8)
    public String getZtyteiritucalckijyunymdx8() {
        return ztyteiritucalckijyunymdx8;
    }

    public void setZtyteiritucalckijyunymdx8(String pZtyteiritucalckijyunymdx8) {
        ztyteiritucalckijyunymdx8 = pZtyteiritucalckijyunymdx8;
    }

    private Long ztyteiritutumitatekinx8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX8)
    public Long getZtyteiritutumitatekinx8() {
        return ztyteiritutumitatekinx8;
    }

    public void setZtyteiritutumitatekinx8(Long pZtyteiritutumitatekinx8) {
        ztyteiritutumitatekinx8 = pZtyteiritutumitatekinx8;
    }

    private String ztyyobiv16x8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X8)
    public String getZtyyobiv16x8() {
        return ztyyobiv16x8;
    }

    public void setZtyyobiv16x8(String pZtyyobiv16x8) {
        ztyyobiv16x8 = pZtyyobiv16x8;
    }

    private String ztyteiritucalckijyunymdx9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX9)
    public String getZtyteiritucalckijyunymdx9() {
        return ztyteiritucalckijyunymdx9;
    }

    public void setZtyteiritucalckijyunymdx9(String pZtyteiritucalckijyunymdx9) {
        ztyteiritucalckijyunymdx9 = pZtyteiritucalckijyunymdx9;
    }

    private Long ztyteiritutumitatekinx9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX9)
    public Long getZtyteiritutumitatekinx9() {
        return ztyteiritutumitatekinx9;
    }

    public void setZtyteiritutumitatekinx9(Long pZtyteiritutumitatekinx9) {
        ztyteiritutumitatekinx9 = pZtyteiritutumitatekinx9;
    }

    private String ztyyobiv16x9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X9)
    public String getZtyyobiv16x9() {
        return ztyyobiv16x9;
    }

    public void setZtyyobiv16x9(String pZtyyobiv16x9) {
        ztyyobiv16x9 = pZtyyobiv16x9;
    }

    private String ztyteiritucalckijyunymdx10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX10)
    public String getZtyteiritucalckijyunymdx10() {
        return ztyteiritucalckijyunymdx10;
    }

    public void setZtyteiritucalckijyunymdx10(String pZtyteiritucalckijyunymdx10) {
        ztyteiritucalckijyunymdx10 = pZtyteiritucalckijyunymdx10;
    }

    private Long ztyteiritutumitatekinx10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX10)
    public Long getZtyteiritutumitatekinx10() {
        return ztyteiritutumitatekinx10;
    }

    public void setZtyteiritutumitatekinx10(Long pZtyteiritutumitatekinx10) {
        ztyteiritutumitatekinx10 = pZtyteiritutumitatekinx10;
    }

    private String ztyyobiv16x10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X10)
    public String getZtyyobiv16x10() {
        return ztyyobiv16x10;
    }

    public void setZtyyobiv16x10(String pZtyyobiv16x10) {
        ztyyobiv16x10 = pZtyyobiv16x10;
    }

    private String ztyteiritucalckijyunymdx11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX11)
    public String getZtyteiritucalckijyunymdx11() {
        return ztyteiritucalckijyunymdx11;
    }

    public void setZtyteiritucalckijyunymdx11(String pZtyteiritucalckijyunymdx11) {
        ztyteiritucalckijyunymdx11 = pZtyteiritucalckijyunymdx11;
    }

    private Long ztyteiritutumitatekinx11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX11)
    public Long getZtyteiritutumitatekinx11() {
        return ztyteiritutumitatekinx11;
    }

    public void setZtyteiritutumitatekinx11(Long pZtyteiritutumitatekinx11) {
        ztyteiritutumitatekinx11 = pZtyteiritutumitatekinx11;
    }

    private String ztyyobiv16x11;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X11)
    public String getZtyyobiv16x11() {
        return ztyyobiv16x11;
    }

    public void setZtyyobiv16x11(String pZtyyobiv16x11) {
        ztyyobiv16x11 = pZtyyobiv16x11;
    }

    private String ztyteiritucalckijyunymdx12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX12)
    public String getZtyteiritucalckijyunymdx12() {
        return ztyteiritucalckijyunymdx12;
    }

    public void setZtyteiritucalckijyunymdx12(String pZtyteiritucalckijyunymdx12) {
        ztyteiritucalckijyunymdx12 = pZtyteiritucalckijyunymdx12;
    }

    private Long ztyteiritutumitatekinx12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX12)
    public Long getZtyteiritutumitatekinx12() {
        return ztyteiritutumitatekinx12;
    }

    public void setZtyteiritutumitatekinx12(Long pZtyteiritutumitatekinx12) {
        ztyteiritutumitatekinx12 = pZtyteiritutumitatekinx12;
    }

    private String ztyyobiv16x12;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X12)
    public String getZtyyobiv16x12() {
        return ztyyobiv16x12;
    }

    public void setZtyyobiv16x12(String pZtyyobiv16x12) {
        ztyyobiv16x12 = pZtyyobiv16x12;
    }

    private String ztyteiritucalckijyunymdx13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX13)
    public String getZtyteiritucalckijyunymdx13() {
        return ztyteiritucalckijyunymdx13;
    }

    public void setZtyteiritucalckijyunymdx13(String pZtyteiritucalckijyunymdx13) {
        ztyteiritucalckijyunymdx13 = pZtyteiritucalckijyunymdx13;
    }

    private Long ztyteiritutumitatekinx13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX13)
    public Long getZtyteiritutumitatekinx13() {
        return ztyteiritutumitatekinx13;
    }

    public void setZtyteiritutumitatekinx13(Long pZtyteiritutumitatekinx13) {
        ztyteiritutumitatekinx13 = pZtyteiritutumitatekinx13;
    }

    private String ztyyobiv16x13;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X13)
    public String getZtyyobiv16x13() {
        return ztyyobiv16x13;
    }

    public void setZtyyobiv16x13(String pZtyyobiv16x13) {
        ztyyobiv16x13 = pZtyyobiv16x13;
    }

    private String ztyteiritucalckijyunymdx14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX14)
    public String getZtyteiritucalckijyunymdx14() {
        return ztyteiritucalckijyunymdx14;
    }

    public void setZtyteiritucalckijyunymdx14(String pZtyteiritucalckijyunymdx14) {
        ztyteiritucalckijyunymdx14 = pZtyteiritucalckijyunymdx14;
    }

    private Long ztyteiritutumitatekinx14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX14)
    public Long getZtyteiritutumitatekinx14() {
        return ztyteiritutumitatekinx14;
    }

    public void setZtyteiritutumitatekinx14(Long pZtyteiritutumitatekinx14) {
        ztyteiritutumitatekinx14 = pZtyteiritutumitatekinx14;
    }

    private String ztyyobiv16x14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X14)
    public String getZtyyobiv16x14() {
        return ztyyobiv16x14;
    }

    public void setZtyyobiv16x14(String pZtyyobiv16x14) {
        ztyyobiv16x14 = pZtyyobiv16x14;
    }

    private String ztyteiritucalckijyunymdx15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUCALCKIJYUNYMDX15)
    public String getZtyteiritucalckijyunymdx15() {
        return ztyteiritucalckijyunymdx15;
    }

    public void setZtyteiritucalckijyunymdx15(String pZtyteiritucalckijyunymdx15) {
        ztyteiritucalckijyunymdx15 = pZtyteiritucalckijyunymdx15;
    }

    private Long ztyteiritutumitatekinx15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYTEIRITUTUMITATEKINX15)
    public Long getZtyteiritutumitatekinx15() {
        return ztyteiritutumitatekinx15;
    }

    public void setZtyteiritutumitatekinx15(Long pZtyteiritutumitatekinx15) {
        ztyteiritutumitatekinx15 = pZtyteiritutumitatekinx15;
    }

    private String ztyyobiv16x15;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV16X15)
    public String getZtyyobiv16x15() {
        return ztyyobiv16x15;
    }

    public void setZtyyobiv16x15(String pZtyyobiv16x15) {
        ztyyobiv16x15 = pZtyyobiv16x15;
    }

    private String ztygengakujicalckijyunymd;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYGENGAKUJICALCKIJYUNYMD)
    public String getZtygengakujicalckijyunymd() {
        return ztygengakujicalckijyunymd;
    }

    public void setZtygengakujicalckijyunymd(String pZtygengakujicalckijyunymd) {
        ztygengakujicalckijyunymd = pZtygengakujicalckijyunymd;
    }

    private Long ztygengakujisisuutmttkn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYGENGAKUJISISUUTMTTKN)
    public Long getZtygengakujisisuutmttkn() {
        return ztygengakujisisuutmttkn;
    }

    public void setZtygengakujisisuutmttkn(Long pZtygengakujisisuutmttkn) {
        ztygengakujisisuutmttkn = pZtygengakujisisuutmttkn;
    }

    private Long ztygengakujiteiritutmttkn;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYGENGAKUJITEIRITUTMTTKN)
    public Long getZtygengakujiteiritutmttkn() {
        return ztygengakujiteiritutmttkn;
    }

    public void setZtygengakujiteiritutmttkn(Long pZtygengakujiteiritutmttkn) {
        ztygengakujiteiritutmttkn = pZtygengakujiteiritutmttkn;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private Long ztyyobin11x9;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIN11X9)
    public Long getZtyyobin11x9() {
        return ztyyobin11x9;
    }

    public void setZtyyobin11x9(Long pZtyyobin11x9) {
        ztyyobin11x9 = pZtyyobin11x9;
    }

    private String ztysuuriyouyobin14;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYSUURIYOUYOBIN14)
    public String getZtysuuriyouyobin14() {
        return ztysuuriyouyobin14;
    }

    public void setZtysuuriyouyobin14(String pZtysuuriyouyobin14) {
        ztysuuriyouyobin14 = pZtysuuriyouyobin14;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_SrKbkSsuRnduHknVKnsyuyuTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }
}