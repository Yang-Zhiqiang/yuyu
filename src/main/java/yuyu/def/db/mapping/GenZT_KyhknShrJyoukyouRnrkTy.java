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
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.id.PKZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.GenQZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkTy;

/**
 * 給付金支払状況連絡Fテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KyhknShrJyoukyouRnrkTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KyhknShrJyoukyouRnrkTy}</td><td colspan="3">給付金支払状況連絡Fテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_KyhknShrJyoukyouRnrkTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyukgu ztytksyukgu}</td><td>（中継用）特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakugatakbn ztytokuyakugatakbn}</td><td>（中継用）特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukisi ztytokuyakukisi}</td><td>（中継用）特約期始</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuutohukakbn ztytyuutohukakbn}</td><td>（中継用）中途付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoukataikbn ztyhyoukataikbn}</td><td>（中継用）標下体区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaisisyatodouhukencd ztyatukaisisyatodouhukencd}</td><td>（中継用）扱支社都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakusinkyuukbn ztytokuyakusinkyuukbn}</td><td>（中継用）特約新旧区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkykdai2hihokensyahyj ztytkykdai2hihokensyahyj}</td><td>（中継用）特約第２被保険者表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteisippeisethyj ztytokuteisippeisethyj}</td><td>（中継用）特定疾病セット表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyusyousyaseibetukbn ztyjyusyousyaseibetukbn}</td><td>（中継用）受傷者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokujyusyousyakbn ztykazokujyusyousyakbn}</td><td>（中継用）家族受傷者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunen ztykeiyakunen}</td><td>（中継用）契約年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymannenreihyj ztymannenreihyj}</td><td>（中継用）満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyuuhukbn ztykyuuhukbn}</td><td>（中継用）給付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaijyoutaikbn ztysiharaijyoutaikbn}</td><td>（中継用）支払状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouincd ztysyouincd}</td><td>（中継用）消因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikohasseiymd2 ztyjikohasseiymd2}</td><td>（中継用）事故発生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaikoteiymd ztysyougaikoteiymd}</td><td>（中継用）傷害固定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuinymd ztynyuuinymd}</td><td>（中継用）入院年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrymd ztyshrymd}</td><td>（中継用）支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyuuhuwariai ztykyuuhuwariai}</td><td>（中継用）給付割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaikingakun9 ztysiharaikingakun9}</td><td>（中継用）支払金額Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykyoukaihoukokuyoukingaku ztykyoukaihoukokuyoukingaku}</td><td>（中継用）協会報告用金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytuuinkakujyuuhukakbn ztytuuinkakujyuuhukakbn}</td><td>（中継用）通院カク充付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykangohukahyj ztykangohukahyj}</td><td>（中継用）看護付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonsyoukyuuhukinkbn ztysonsyoukyuuhukinkbn}</td><td>（中継用）損傷給付金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukoudosyougaicd ztysiboukoudosyougaicd}</td><td>（中継用）死亡高度障害コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokikyuuhutandokushrhyj ztysyokikyuuhutandokushrhyj}</td><td>（中継用）初期給付単独支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuseikyuuhukbn ztykakuseikyuuhukbn}</td><td>（中継用）カク成給付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysoukikeakyuuhutuusankisu ztysoukikeakyuuhutuusankisu}</td><td>（中継用）早期ケア給付通算回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyonendokyuuhuwariai ztysyonendokyuuhuwariai}</td><td>（中継用）初年度給付割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyonendosiharaihyj ztysyonendosiharaihyj}</td><td>（中継用）初年度支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x2 ztyyobiv4x2}</td><td>（中継用）予備項目Ｖ４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousingohasseihyj ztykousingohasseihyj}</td><td>（中継用）更新後発生表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybyoumeicd1 ztybyoumeicd1}</td><td>（中継用）病名コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybyoumeicd2 ztybyoumeicd2}</td><td>（中継用）病名コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigaigenincd ztysaigaigenincd}</td><td>（中継用）災害原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitoukyuugou ztysyougaitoukyuugou}</td><td>（中継用）障害等級号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyujyutucd ztysyujyutucd}</td><td>（中継用）手術コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyujyutumeicd ztysyujyutumeicd}</td><td>（中継用）手術名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuinkangogeninkbn ztytuuinkangogeninkbn}</td><td>（中継用）通院看護原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyundoukisonsyoukbn ztyundoukisonsyoukbn}</td><td>（中継用）運動器損傷区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganmensonsyoukbn ztyganmensonsyoukbn}</td><td>（中継用）顔面損傷区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonsyougeninkbn ztysonsyougeninkbn}</td><td>（中継用）損傷原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikensportskbn ztykikensportskbn}</td><td>（中継用）危険スポーツ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x2 ztyyobiv2x2}</td><td>（中継用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharainissuukbn ztysiharainissuukbn}</td><td>（中継用）支払日数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuseikatakbn ztykakuseikatakbn}</td><td>（中継用）カク成型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeirokbn ztybosyuukeirokbn}</td><td>（中継用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpohyj ztypmenhutanpohyj}</td><td>（中継用）Ｐ免不担保表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinkbn ztykousinkbn}</td><td>（中継用）更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykusnmetkyksykipjyutuym ztykusnmetkyksykipjyutuym}</td><td>（中継用）更新前特約初回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhukakbn ztypmenhukakbn}</td><td>（中継用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenkbnv2 ztypmenkbnv2}</td><td>（中継用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketteikijyunkanwakbn ztyketteikijyunkanwakbn}</td><td>（中継用）決定基準緩和区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukigousedaikbn ztytokuyakukigousedaikbn}</td><td>（中継用）特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssnskbn ztystdssnskbn}</td><td>（中継用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasikousinkbn ztysotodasikousinkbn}</td><td>（中継用）外出更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5 ztyyobiv5}</td><td>（中継用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyqpackhyj ztyqpackhyj}</td><td>（中継用）Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybunkatukbn ztybunkatukbn}</td><td>（中継用）分割区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanhosyouminaosikbn ztytenkanhosyouminaosikbn}</td><td>（中継用）転換保障見直区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinmaesiharaihyj ztykousinmaesiharaihyj}</td><td>（中継用）更新前支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydouitunyuuinno ztydouitunyuuinno}</td><td>（中継用）同一入院番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyujyutujinyuuinkbn ztysyujyutujinyuuinkbn}</td><td>（中継用）手術時入院区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyujyutusyuruikbn ztysyujyutusyuruikbn}</td><td>（中継用）手術種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygannyuuinkbn ztygannyuuinkbn}</td><td>（中継用）がん入院区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokenhoutekiyouhyouji ztyhokenhoutekiyouhyouji}</td><td>（中継用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasiphkbnmnoshyouji ztysotodasiphkbnmnoshyouji}</td><td>（中継用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteijyoutaihushrhyj ztytokuteijyoutaihushrhyj}</td><td>（中継用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyacd ztysisyacd}</td><td>（中継用）支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobiv11 ztysuuriyouyobiv11}</td><td>（中継用）数理用予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoukaigojyoutaikaisiymd ztyyoukaigojyoutaikaisiymd}</td><td>（中継用）要介護状態開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoukaigojyoutaiendymd ztyyoukaigojyoutaiendymd}</td><td>（中継用）要介護状態終了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyousntkjyubbnhyj ztyrendouyousntkjyubbnhyj}</td><td>（中継用）連動用新特条部分表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusentakukeiyakukbn ztymusentakukeiyakukbn}</td><td>（中継用）無選択契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteiskeijihukahyj ztymaruteiskeijihukahyj}</td><td>（中継用）マル定新契約時付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoliplhyj ztytoliplhyj}</td><td>（中継用）ＴＯＬＩＰＬ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssytikbn ztystdssytikbn}</td><td>（中継用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhisei ztyhisei}</td><td>（中継用）被性</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyobin9 ztysuuriyobin9}</td><td>（中継用）数理予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysaigaisibousiharaikngk ztysaigaisibousiharaikngk}</td><td>（中継用）災害死亡支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokuyakuhinen ztytokuyakuhinen}</td><td>（中継用）特約被年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnykbttryukyuhkntusnkisu ztygnykbttryukyuhkntusnkisu}</td><td>（中継用）がん薬物治療給付金通算回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygansyuruikbn ztygansyuruikbn}</td><td>（中継用）がん種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyganyakubutusyuruikbn ztyganyakubutusyuruikbn}</td><td>（中継用）がん薬物種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuuroukigjyujtjyutikbn ztysyuuroukigjyujtjyutikbn}</td><td>（中継用）就労介護充実状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuuroukigjyujtgeninkbn ztysyuuroukigjyujtgeninkbn}</td><td>（中継用）就労介護充実原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigjyujtjyoutaigeninkbn ztykigjyujtjyoutaigeninkbn}</td><td>（中継用）介護充実状態原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykmtssyukahikbn ztysykmtssyukahikbn}</td><td>（中継用）食物摂取可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfktrsmtkahikbn ztyfktrsmtkahikbn}</td><td>（中継用）拭き取り始末可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokoukahikbn ztyhokoukahikbn}</td><td>（中継用）歩行可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyykkahikbn ztynyykkahikbn}</td><td>（中継用）入浴可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyihukutyakudatukahikbn ztyihukutyakudatukahikbn}</td><td>（中継用）衣服着脱可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyngerkahikbn ztyngerkahikbn}</td><td>（中継用）寝返り可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseiketuseiyoukahikbn ztyseiketuseiyoukahikbn}</td><td>（中継用）清潔整容可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynintisyougeninkbn ztynintisyougeninkbn}</td><td>（中継用）認知症原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruhnujyujtjyutikbn ztysyuruhnujyujtjyutikbn}</td><td>（中継用）就労不能充実状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteisyougaikbn ztytokuteisyougaikbn}</td><td>（中継用）特定障害区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino2 ztydatakanrino2}</td><td>（中継用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino3 ztydatakanrino3}</td><td>（中継用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybluekeizokuhyouji ztybluekeizokuhyouji}</td><td>（中継用）Ｂｌｕｅ継続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbn ztyzyrthntiyustatuskbn}</td><td>（中継用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx2 ztyzyrthntiyustatuskbnx2}</td><td>（中継用）乗率判定用ステータス区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx3 ztyzyrthntiyustatuskbnx3}</td><td>（中継用）乗率判定用ステータス区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx4 ztyzyrthntiyustatuskbnx4}</td><td>（中継用）乗率判定用ステータス区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx5 ztyzyrthntiyustatuskbnx5}</td><td>（中継用）乗率判定用ステータス区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrtx2 ztyknkuzusnzyrtx2}</td><td>（中継用）健康増進乗率＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkeiyakujivithkhyouji ztysinkeiyakujivithkhyouji}</td><td>（中継用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwrbksidhitekiyouhyj ztypwrbksidhitekiyouhyj}</td><td>（中継用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin4 ztysuuriyouyobin4}</td><td>（中継用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygaikadatesiharais ztygaikadatesiharais}</td><td>（中継用）外貨建支払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakus ztygaikadatesyukeiyakus}</td><td>（中継用）外貨建主契約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakup ztygaikadatesyukeiyakup}</td><td>（中継用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10 ztysuuriyouyobin10}</td><td>（中継用）数理用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x2 ztyyobiv10x2}</td><td>（中継用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvatyouseigow ztymvatyouseigow}</td><td>（中継用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymvakeisanjisknnjynbkn ztymvakeisanjisknnjynbkn}</td><td>（中継用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KyhknShrJyoukyouRnrkTy
 * @see     PKZT_KyhknShrJyoukyouRnrkTy
 * @see     QZT_KyhknShrJyoukyouRnrkTy
 * @see     GenQZT_KyhknShrJyoukyouRnrkTy
 */
@MappedSuperclass
@Table(name=GenZT_KyhknShrJyoukyouRnrkTy.TABLE_NAME)
@IdClass(value=PKZT_KyhknShrJyoukyouRnrkTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KyhknShrJyoukyouRnrkTy extends AbstractExDBEntity<ZT_KyhknShrJyoukyouRnrkTy, PKZT_KyhknShrJyoukyouRnrkTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KyhknShrJyoukyouRnrkTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYTKSYUKGU              = "ztytksyukgu";
    public static final String ZTYTOKUYAKUGATAKBN       = "ztytokuyakugatakbn";
    public static final String ZTYTOKUYAKUKISI          = "ztytokuyakukisi";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYTYUUTOHUKAKBN         = "ztytyuutohukakbn";
    public static final String ZTYHYOUKATAIKBN          = "ztyhyoukataikbn";
    public static final String ZTYATUKAISISYATODOUHUKENCD = "ztyatukaisisyatodouhukencd";
    public static final String ZTYTOKUYAKUSINKYUUKBN    = "ztytokuyakusinkyuukbn";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYTKYKDAI2HIHOKENSYAHYJ = "ztytkykdai2hihokensyahyj";
    public static final String ZTYTOKUTEISIPPEISETHYJ   = "ztytokuteisippeisethyj";
    public static final String ZTYJYUSYOUSYASEIBETUKBN  = "ztyjyusyousyaseibetukbn";
    public static final String ZTYKAZOKUJYUSYOUSYAKBN   = "ztykazokujyusyousyakbn";
    public static final String ZTYKEIYAKUNEN            = "ztykeiyakunen";
    public static final String ZTYMANNENREIHYJ          = "ztymannenreihyj";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYKYUUHUKBN             = "ztykyuuhukbn";
    public static final String ZTYSIHARAIJYOUTAIKBN     = "ztysiharaijyoutaikbn";
    public static final String ZTYSYOUINCD              = "ztysyouincd";
    public static final String ZTYJIKOHASSEIYMD2        = "ztyjikohasseiymd2";
    public static final String ZTYSYOUGAIKOTEIYMD       = "ztysyougaikoteiymd";
    public static final String ZTYNYUUINYMD             = "ztynyuuinymd";
    public static final String ZTYSHRYMD                = "ztyshrymd";
    public static final String ZTYKYUUHUWARIAI          = "ztykyuuhuwariai";
    public static final String ZTYSIHARAIKINGAKUN9      = "ztysiharaikingakun9";
    public static final String ZTYKYOUKAIHOUKOKUYOUKINGAKU = "ztykyoukaihoukokuyoukingaku";
    public static final String ZTYTUUINKAKUJYUUHUKAKBN  = "ztytuuinkakujyuuhukakbn";
    public static final String ZTYKANGOHUKAHYJ          = "ztykangohukahyj";
    public static final String ZTYSONSYOUKYUUHUKINKBN   = "ztysonsyoukyuuhukinkbn";
    public static final String ZTYSIBOUKOUDOSYOUGAICD   = "ztysiboukoudosyougaicd";
    public static final String ZTYSYOKIKYUUHUTANDOKUSHRHYJ = "ztysyokikyuuhutandokushrhyj";
    public static final String ZTYKAKUSEIKYUUHUKBN      = "ztykakuseikyuuhukbn";
    public static final String ZTYSOUKIKEAKYUUHUTUUSANKISU = "ztysoukikeakyuuhutuusankisu";
    public static final String ZTYSYONENDOKYUUHUWARIAI  = "ztysyonendokyuuhuwariai";
    public static final String ZTYSYONENDOSIHARAIHYJ    = "ztysyonendosiharaihyj";
    public static final String ZTYYOBIV4X2              = "ztyyobiv4x2";
    public static final String ZTYKOUSINGOHASSEIHYJ     = "ztykousingohasseihyj";
    public static final String ZTYBYOUMEICD1            = "ztybyoumeicd1";
    public static final String ZTYBYOUMEICD2            = "ztybyoumeicd2";
    public static final String ZTYSAIGAIGENINCD         = "ztysaigaigenincd";
    public static final String ZTYSYOUGAITOUKYUUGOU     = "ztysyougaitoukyuugou";
    public static final String ZTYSYUJYUTUCD            = "ztysyujyutucd";
    public static final String ZTYSYUJYUTUMEICD         = "ztysyujyutumeicd";
    public static final String ZTYTUUINKANGOGENINKBN    = "ztytuuinkangogeninkbn";
    public static final String ZTYUNDOUKISONSYOUKBN     = "ztyundoukisonsyoukbn";
    public static final String ZTYGANMENSONSYOUKBN      = "ztyganmensonsyoukbn";
    public static final String ZTYSONSYOUGENINKBN       = "ztysonsyougeninkbn";
    public static final String ZTYKIKENSPORTSKBN        = "ztykikensportskbn";
    public static final String ZTYYOBIV2X2              = "ztyyobiv2x2";
    public static final String ZTYSIHARAINISSUUKBN      = "ztysiharainissuukbn";
    public static final String ZTYKAKUSEIKATAKBN        = "ztykakuseikatakbn";
    public static final String ZTYBOSYUUKEIROKBN        = "ztybosyuukeirokbn";
    public static final String ZTYPMENHUTANPOHYJ        = "ztypmenhutanpohyj";
    public static final String ZTYKOUSINKBN             = "ztykousinkbn";
    public static final String ZTYKUSNMETKYKSYKIPJYUTUYM = "ztykusnmetkyksykipjyutuym";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYPMENHUKAKBN           = "ztypmenhukakbn";
    public static final String ZTYPMENKBNV2             = "ztypmenkbnv2";
    public static final String ZTYKETTEIKIJYUNKANWAKBN  = "ztyketteikijyunkanwakbn";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYTOKUYAKUKIGOUSEDAIKBN = "ztytokuyakukigousedaikbn";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYSTDSSNSKBN            = "ztystdssnskbn";
    public static final String ZTYSOTODASIKOUSINKBN     = "ztysotodasikousinkbn";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYYOBIV5                = "ztyyobiv5";
    public static final String ZTYQPACKHYJ              = "ztyqpackhyj";
    public static final String ZTYBUNKATUKBN            = "ztybunkatukbn";
    public static final String ZTYTENKANHOSYOUMINAOSIKBN = "ztytenkanhosyouminaosikbn";
    public static final String ZTYKOUSINMAESIHARAIHYJ   = "ztykousinmaesiharaihyj";
    public static final String ZTYDOUITUNYUUINNO        = "ztydouitunyuuinno";
    public static final String ZTYSYUJYUTUJINYUUINKBN   = "ztysyujyutujinyuuinkbn";
    public static final String ZTYSYUJYUTUSYURUIKBN     = "ztysyujyutusyuruikbn";
    public static final String ZTYGANNYUUINKBN          = "ztygannyuuinkbn";
    public static final String ZTYHOKENHOUTEKIYOUHYOUJI = "ztyhokenhoutekiyouhyouji";
    public static final String ZTYSOTODASIPHKBNMNOSHYOUJI = "ztysotodasiphkbnmnoshyouji";
    public static final String ZTYTOKUTEIJYOUTAIHUSHRHYJ = "ztytokuteijyoutaihushrhyj";
    public static final String ZTYSISYACD               = "ztysisyacd";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYSUURIYOUYOBIV11       = "ztysuuriyouyobiv11";
    public static final String ZTYYOUKAIGOJYOUTAIKAISIYMD = "ztyyoukaigojyoutaikaisiymd";
    public static final String ZTYYOUKAIGOJYOUTAIENDYMD = "ztyyoukaigojyoutaiendymd";
    public static final String ZTYRENDOUYOUSNTKJYUBBNHYJ = "ztyrendouyousntkjyubbnhyj";
    public static final String ZTYMUSENTAKUKEIYAKUKBN   = "ztymusentakukeiyakukbn";
    public static final String ZTYMARUTEISKEIJIHUKAHYJ  = "ztymaruteiskeijihukahyj";
    public static final String ZTYTOLIPLHYJ             = "ztytoliplhyj";
    public static final String ZTYSTDSSYTIKBN           = "ztystdssytikbn";
    public static final String ZTYHISEI                 = "ztyhisei";
    public static final String ZTYSUURIYOBIN9           = "ztysuuriyobin9";
    public static final String ZTYSAIGAISIBOUSIHARAIKNGK = "ztysaigaisibousiharaikngk";
    public static final String ZTYTOKUYAKUHINEN         = "ztytokuyakuhinen";
    public static final String ZTYGNYKBTTRYUKYUHKNTUSNKISU = "ztygnykbttryukyuhkntusnkisu";
    public static final String ZTYGANSYURUIKBN          = "ztygansyuruikbn";
    public static final String ZTYGANYAKUBUTUSYURUIKBN  = "ztyganyakubutusyuruikbn";
    public static final String ZTYSYUUROUKIGJYUJTJYUTIKBN = "ztysyuuroukigjyujtjyutikbn";
    public static final String ZTYSYUUROUKIGJYUJTGENINKBN = "ztysyuuroukigjyujtgeninkbn";
    public static final String ZTYKIGJYUJTJYOUTAIGENINKBN = "ztykigjyujtjyoutaigeninkbn";
    public static final String ZTYSYKMTSSYUKAHIKBN      = "ztysykmtssyukahikbn";
    public static final String ZTYFKTRSMTKAHIKBN        = "ztyfktrsmtkahikbn";
    public static final String ZTYHOKOUKAHIKBN          = "ztyhokoukahikbn";
    public static final String ZTYNYYKKAHIKBN           = "ztynyykkahikbn";
    public static final String ZTYIHUKUTYAKUDATUKAHIKBN = "ztyihukutyakudatukahikbn";
    public static final String ZTYNGERKAHIKBN           = "ztyngerkahikbn";
    public static final String ZTYSEIKETUSEIYOUKAHIKBN  = "ztyseiketuseiyoukahikbn";
    public static final String ZTYNINTISYOUGENINKBN     = "ztynintisyougeninkbn";
    public static final String ZTYSYURUHNUJYUJTJYUTIKBN = "ztysyuruhnujyujtjyutikbn";
    public static final String ZTYTOKUTEISYOUGAIKBN     = "ztytokuteisyougaikbn";
    public static final String ZTYDATAKANRINO2          = "ztydatakanrino2";
    public static final String ZTYDATAKANRINO3          = "ztydatakanrino3";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYBLUEKEIZOKUHYOUJI     = "ztybluekeizokuhyouji";
    public static final String ZTYZYRTHNTIYUSTATUSKBN   = "ztyzyrthntiyustatuskbn";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX2 = "ztyzyrthntiyustatuskbnx2";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX3 = "ztyzyrthntiyustatuskbnx3";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX4 = "ztyzyrthntiyustatuskbnx4";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX5 = "ztyzyrthntiyustatuskbnx5";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYKNKUZUSNZYRTX2        = "ztyknkuzusnzyrtx2";
    public static final String ZTYSINKEIYAKUJIVITHKHYOUJI = "ztysinkeiyakujivithkhyouji";
    public static final String ZTYPWRBKSIDHITEKIYOUHYJ  = "ztypwrbksidhitekiyouhyj";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYSUURIYOUYOBIN4        = "ztysuuriyouyobin4";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYGAIKADATESIHARAIS     = "ztygaikadatesiharais";
    public static final String ZTYGAIKADATESYUKEIYAKUS  = "ztygaikadatesyukeiyakus";
    public static final String ZTYGAIKADATESYUKEIYAKUP  = "ztygaikadatesyukeiyakup";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYSUURIYOUYOBIN10       = "ztysuuriyouyobin10";
    public static final String ZTYYOBIV10X2             = "ztyyobiv10x2";
    public static final String ZTYMVATYOUSEIGOW         = "ztymvatyouseigow";
    public static final String ZTYMVAKEISANJISKNNJYNBKN = "ztymvakeisanjisknnjynbkn";
    public static final String ZTYYOBIV6                = "ztyyobiv6";

    private final PKZT_KyhknShrJyoukyouRnrkTy primaryKey;

    public GenZT_KyhknShrJyoukyouRnrkTy() {
        primaryKey = new PKZT_KyhknShrJyoukyouRnrkTy();
    }

    public GenZT_KyhknShrJyoukyouRnrkTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_KyhknShrJyoukyouRnrkTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_KyhknShrJyoukyouRnrkTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KyhknShrJyoukyouRnrkTy> getMetaClass() {
        return QZT_KyhknShrJyoukyouRnrkTy.class;
    }

    @Id
    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztyyobiv12;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    private String ztytksyukgu;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTKSYUKGU)
    public String getZtytksyukgu() {
        return ztytksyukgu;
    }

    public void setZtytksyukgu(String pZtytksyukgu) {
        ztytksyukgu = pZtytksyukgu;
    }

    private String ztytokuyakugatakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUYAKUGATAKBN)
    public String getZtytokuyakugatakbn() {
        return ztytokuyakugatakbn;
    }

    public void setZtytokuyakugatakbn(String pZtytokuyakugatakbn) {
        ztytokuyakugatakbn = pZtytokuyakugatakbn;
    }

    private String ztytokuyakukisi;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUYAKUKISI)
    public String getZtytokuyakukisi() {
        return ztytokuyakukisi;
    }

    public void setZtytokuyakukisi(String pZtytokuyakukisi) {
        ztytokuyakukisi = pZtytokuyakukisi;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztytyuutohukakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTYUUTOHUKAKBN)
    public String getZtytyuutohukakbn() {
        return ztytyuutohukakbn;
    }

    public void setZtytyuutohukakbn(String pZtytyuutohukakbn) {
        ztytyuutohukakbn = pZtytyuutohukakbn;
    }

    private String ztyhyoukataikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYHYOUKATAIKBN)
    public String getZtyhyoukataikbn() {
        return ztyhyoukataikbn;
    }

    public void setZtyhyoukataikbn(String pZtyhyoukataikbn) {
        ztyhyoukataikbn = pZtyhyoukataikbn;
    }

    private String ztyatukaisisyatodouhukencd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYATUKAISISYATODOUHUKENCD)
    public String getZtyatukaisisyatodouhukencd() {
        return ztyatukaisisyatodouhukencd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyatukaisisyatodouhukencd(String pZtyatukaisisyatodouhukencd) {
        ztyatukaisisyatodouhukencd = pZtyatukaisisyatodouhukencd;
    }

    private String ztytokuyakusinkyuukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUYAKUSINKYUUKBN)
    public String getZtytokuyakusinkyuukbn() {
        return ztytokuyakusinkyuukbn;
    }

    public void setZtytokuyakusinkyuukbn(String pZtytokuyakusinkyuukbn) {
        ztytokuyakusinkyuukbn = pZtytokuyakusinkyuukbn;
    }

    private String ztybsyym;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztytkykdai2hihokensyahyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTKYKDAI2HIHOKENSYAHYJ)
    public String getZtytkykdai2hihokensyahyj() {
        return ztytkykdai2hihokensyahyj;
    }

    public void setZtytkykdai2hihokensyahyj(String pZtytkykdai2hihokensyahyj) {
        ztytkykdai2hihokensyahyj = pZtytkykdai2hihokensyahyj;
    }

    private String ztytokuteisippeisethyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUTEISIPPEISETHYJ)
    public String getZtytokuteisippeisethyj() {
        return ztytokuteisippeisethyj;
    }

    public void setZtytokuteisippeisethyj(String pZtytokuteisippeisethyj) {
        ztytokuteisippeisethyj = pZtytokuteisippeisethyj;
    }

    private String ztyjyusyousyaseibetukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYJYUSYOUSYASEIBETUKBN)
    public String getZtyjyusyousyaseibetukbn() {
        return ztyjyusyousyaseibetukbn;
    }

    public void setZtyjyusyousyaseibetukbn(String pZtyjyusyousyaseibetukbn) {
        ztyjyusyousyaseibetukbn = pZtyjyusyousyaseibetukbn;
    }

    private String ztykazokujyusyousyakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKAZOKUJYUSYOUSYAKBN)
    public String getZtykazokujyusyousyakbn() {
        return ztykazokujyusyousyakbn;
    }

    public void setZtykazokujyusyousyakbn(String pZtykazokujyusyousyakbn) {
        ztykazokujyusyousyakbn = pZtykazokujyusyousyakbn;
    }

    private String ztykeiyakunen;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKEIYAKUNEN)
    public String getZtykeiyakunen() {
        return ztykeiyakunen;
    }

    public void setZtykeiyakunen(String pZtykeiyakunen) {
        ztykeiyakunen = pZtykeiyakunen;
    }

    private String ztymannenreihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYMANNENREIHYJ)
    public String getZtymannenreihyj() {
        return ztymannenreihyj;
    }

    public void setZtymannenreihyj(String pZtymannenreihyj) {
        ztymannenreihyj = pZtymannenreihyj;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztyyobiv2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private String ztykyuuhukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKYUUHUKBN)
    public String getZtykyuuhukbn() {
        return ztykyuuhukbn;
    }

    public void setZtykyuuhukbn(String pZtykyuuhukbn) {
        ztykyuuhukbn = pZtykyuuhukbn;
    }

    private String ztysiharaijyoutaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSIHARAIJYOUTAIKBN)
    public String getZtysiharaijyoutaikbn() {
        return ztysiharaijyoutaikbn;
    }

    public void setZtysiharaijyoutaikbn(String pZtysiharaijyoutaikbn) {
        ztysiharaijyoutaikbn = pZtysiharaijyoutaikbn;
    }

    private String ztysyouincd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYOUINCD)
    public String getZtysyouincd() {
        return ztysyouincd;
    }

    public void setZtysyouincd(String pZtysyouincd) {
        ztysyouincd = pZtysyouincd;
    }

    private String ztyjikohasseiymd2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYJIKOHASSEIYMD2)
    public String getZtyjikohasseiymd2() {
        return ztyjikohasseiymd2;
    }

    public void setZtyjikohasseiymd2(String pZtyjikohasseiymd2) {
        ztyjikohasseiymd2 = pZtyjikohasseiymd2;
    }

    private String ztysyougaikoteiymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYOUGAIKOTEIYMD)
    public String getZtysyougaikoteiymd() {
        return ztysyougaikoteiymd;
    }

    public void setZtysyougaikoteiymd(String pZtysyougaikoteiymd) {
        ztysyougaikoteiymd = pZtysyougaikoteiymd;
    }

    private String ztynyuuinymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYNYUUINYMD)
    public String getZtynyuuinymd() {
        return ztynyuuinymd;
    }

    public void setZtynyuuinymd(String pZtynyuuinymd) {
        ztynyuuinymd = pZtynyuuinymd;
    }

    private String ztyshrymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSHRYMD)
    public String getZtyshrymd() {
        return ztyshrymd;
    }

    public void setZtyshrymd(String pZtyshrymd) {
        ztyshrymd = pZtyshrymd;
    }

    private String ztykyuuhuwariai;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKYUUHUWARIAI)
    public String getZtykyuuhuwariai() {
        return ztykyuuhuwariai;
    }

    public void setZtykyuuhuwariai(String pZtykyuuhuwariai) {
        ztykyuuhuwariai = pZtykyuuhuwariai;
    }

    private Integer ztysiharaikingakun9;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSIHARAIKINGAKUN9)
    public Integer getZtysiharaikingakun9() {
        return ztysiharaikingakun9;
    }

    public void setZtysiharaikingakun9(Integer pZtysiharaikingakun9) {
        ztysiharaikingakun9 = pZtysiharaikingakun9;
    }

    private Integer ztykyoukaihoukokuyoukingaku;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKYOUKAIHOUKOKUYOUKINGAKU)
    public Integer getZtykyoukaihoukokuyoukingaku() {
        return ztykyoukaihoukokuyoukingaku;
    }

    public void setZtykyoukaihoukokuyoukingaku(Integer pZtykyoukaihoukokuyoukingaku) {
        ztykyoukaihoukokuyoukingaku = pZtykyoukaihoukokuyoukingaku;
    }

    private String ztytuuinkakujyuuhukakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTUUINKAKUJYUUHUKAKBN)
    public String getZtytuuinkakujyuuhukakbn() {
        return ztytuuinkakujyuuhukakbn;
    }

    public void setZtytuuinkakujyuuhukakbn(String pZtytuuinkakujyuuhukakbn) {
        ztytuuinkakujyuuhukakbn = pZtytuuinkakujyuuhukakbn;
    }

    private String ztykangohukahyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKANGOHUKAHYJ)
    public String getZtykangohukahyj() {
        return ztykangohukahyj;
    }

    public void setZtykangohukahyj(String pZtykangohukahyj) {
        ztykangohukahyj = pZtykangohukahyj;
    }

    private String ztysonsyoukyuuhukinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSONSYOUKYUUHUKINKBN)
    public String getZtysonsyoukyuuhukinkbn() {
        return ztysonsyoukyuuhukinkbn;
    }

    public void setZtysonsyoukyuuhukinkbn(String pZtysonsyoukyuuhukinkbn) {
        ztysonsyoukyuuhukinkbn = pZtysonsyoukyuuhukinkbn;
    }

    private String ztysiboukoudosyougaicd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSIBOUKOUDOSYOUGAICD)
    public String getZtysiboukoudosyougaicd() {
        return ztysiboukoudosyougaicd;
    }

    public void setZtysiboukoudosyougaicd(String pZtysiboukoudosyougaicd) {
        ztysiboukoudosyougaicd = pZtysiboukoudosyougaicd;
    }

    private String ztysyokikyuuhutandokushrhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYOKIKYUUHUTANDOKUSHRHYJ)
    public String getZtysyokikyuuhutandokushrhyj() {
        return ztysyokikyuuhutandokushrhyj;
    }

    public void setZtysyokikyuuhutandokushrhyj(String pZtysyokikyuuhutandokushrhyj) {
        ztysyokikyuuhutandokushrhyj = pZtysyokikyuuhutandokushrhyj;
    }

    private String ztykakuseikyuuhukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKAKUSEIKYUUHUKBN)
    public String getZtykakuseikyuuhukbn() {
        return ztykakuseikyuuhukbn;
    }

    public void setZtykakuseikyuuhukbn(String pZtykakuseikyuuhukbn) {
        ztykakuseikyuuhukbn = pZtykakuseikyuuhukbn;
    }

    private String ztysoukikeakyuuhutuusankisu;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSOUKIKEAKYUUHUTUUSANKISU)
    public String getZtysoukikeakyuuhutuusankisu() {
        return ztysoukikeakyuuhutuusankisu;
    }

    public void setZtysoukikeakyuuhutuusankisu(String pZtysoukikeakyuuhutuusankisu) {
        ztysoukikeakyuuhutuusankisu = pZtysoukikeakyuuhutuusankisu;
    }

    private String ztysyonendokyuuhuwariai;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYONENDOKYUUHUWARIAI)
    public String getZtysyonendokyuuhuwariai() {
        return ztysyonendokyuuhuwariai;
    }

    public void setZtysyonendokyuuhuwariai(String pZtysyonendokyuuhuwariai) {
        ztysyonendokyuuhuwariai = pZtysyonendokyuuhuwariai;
    }

    private String ztysyonendosiharaihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYONENDOSIHARAIHYJ)
    public String getZtysyonendosiharaihyj() {
        return ztysyonendosiharaihyj;
    }

    public void setZtysyonendosiharaihyj(String pZtysyonendosiharaihyj) {
        ztysyonendosiharaihyj = pZtysyonendosiharaihyj;
    }

    private String ztyyobiv4x2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV4X2)
    public String getZtyyobiv4x2() {
        return ztyyobiv4x2;
    }

    public void setZtyyobiv4x2(String pZtyyobiv4x2) {
        ztyyobiv4x2 = pZtyyobiv4x2;
    }

    private String ztykousingohasseihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKOUSINGOHASSEIHYJ)
    public String getZtykousingohasseihyj() {
        return ztykousingohasseihyj;
    }

    public void setZtykousingohasseihyj(String pZtykousingohasseihyj) {
        ztykousingohasseihyj = pZtykousingohasseihyj;
    }

    private String ztybyoumeicd1;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYBYOUMEICD1)
    public String getZtybyoumeicd1() {
        return ztybyoumeicd1;
    }

    public void setZtybyoumeicd1(String pZtybyoumeicd1) {
        ztybyoumeicd1 = pZtybyoumeicd1;
    }

    private String ztybyoumeicd2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYBYOUMEICD2)
    public String getZtybyoumeicd2() {
        return ztybyoumeicd2;
    }

    public void setZtybyoumeicd2(String pZtybyoumeicd2) {
        ztybyoumeicd2 = pZtybyoumeicd2;
    }

    private String ztysaigaigenincd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSAIGAIGENINCD)
    public String getZtysaigaigenincd() {
        return ztysaigaigenincd;
    }

    public void setZtysaigaigenincd(String pZtysaigaigenincd) {
        ztysaigaigenincd = pZtysaigaigenincd;
    }

    private String ztysyougaitoukyuugou;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYOUGAITOUKYUUGOU)
    public String getZtysyougaitoukyuugou() {
        return ztysyougaitoukyuugou;
    }

    public void setZtysyougaitoukyuugou(String pZtysyougaitoukyuugou) {
        ztysyougaitoukyuugou = pZtysyougaitoukyuugou;
    }

    private String ztysyujyutucd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYUJYUTUCD)
    public String getZtysyujyutucd() {
        return ztysyujyutucd;
    }

    public void setZtysyujyutucd(String pZtysyujyutucd) {
        ztysyujyutucd = pZtysyujyutucd;
    }

    private String ztysyujyutumeicd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYUJYUTUMEICD)
    public String getZtysyujyutumeicd() {
        return ztysyujyutumeicd;
    }

    public void setZtysyujyutumeicd(String pZtysyujyutumeicd) {
        ztysyujyutumeicd = pZtysyujyutumeicd;
    }

    private String ztytuuinkangogeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTUUINKANGOGENINKBN)
    public String getZtytuuinkangogeninkbn() {
        return ztytuuinkangogeninkbn;
    }

    public void setZtytuuinkangogeninkbn(String pZtytuuinkangogeninkbn) {
        ztytuuinkangogeninkbn = pZtytuuinkangogeninkbn;
    }

    private String ztyundoukisonsyoukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYUNDOUKISONSYOUKBN)
    public String getZtyundoukisonsyoukbn() {
        return ztyundoukisonsyoukbn;
    }

    public void setZtyundoukisonsyoukbn(String pZtyundoukisonsyoukbn) {
        ztyundoukisonsyoukbn = pZtyundoukisonsyoukbn;
    }

    private String ztyganmensonsyoukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGANMENSONSYOUKBN)
    public String getZtyganmensonsyoukbn() {
        return ztyganmensonsyoukbn;
    }

    public void setZtyganmensonsyoukbn(String pZtyganmensonsyoukbn) {
        ztyganmensonsyoukbn = pZtyganmensonsyoukbn;
    }

    private String ztysonsyougeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSONSYOUGENINKBN)
    public String getZtysonsyougeninkbn() {
        return ztysonsyougeninkbn;
    }

    public void setZtysonsyougeninkbn(String pZtysonsyougeninkbn) {
        ztysonsyougeninkbn = pZtysonsyougeninkbn;
    }

    private String ztykikensportskbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKIKENSPORTSKBN)
    public String getZtykikensportskbn() {
        return ztykikensportskbn;
    }

    public void setZtykikensportskbn(String pZtykikensportskbn) {
        ztykikensportskbn = pZtykikensportskbn;
    }

    private String ztyyobiv2x2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV2X2)
    public String getZtyyobiv2x2() {
        return ztyyobiv2x2;
    }

    public void setZtyyobiv2x2(String pZtyyobiv2x2) {
        ztyyobiv2x2 = pZtyyobiv2x2;
    }

    private String ztysiharainissuukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSIHARAINISSUUKBN)
    public String getZtysiharainissuukbn() {
        return ztysiharainissuukbn;
    }

    public void setZtysiharainissuukbn(String pZtysiharainissuukbn) {
        ztysiharainissuukbn = pZtysiharainissuukbn;
    }

    private String ztykakuseikatakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKAKUSEIKATAKBN)
    public String getZtykakuseikatakbn() {
        return ztykakuseikatakbn;
    }

    public void setZtykakuseikatakbn(String pZtykakuseikatakbn) {
        ztykakuseikatakbn = pZtykakuseikatakbn;
    }

    private String ztybosyuukeirokbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYBOSYUUKEIROKBN)
    public String getZtybosyuukeirokbn() {
        return ztybosyuukeirokbn;
    }

    public void setZtybosyuukeirokbn(String pZtybosyuukeirokbn) {
        ztybosyuukeirokbn = pZtybosyuukeirokbn;
    }

    private String ztypmenhutanpohyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYPMENHUTANPOHYJ)
    public String getZtypmenhutanpohyj() {
        return ztypmenhutanpohyj;
    }

    public void setZtypmenhutanpohyj(String pZtypmenhutanpohyj) {
        ztypmenhutanpohyj = pZtypmenhutanpohyj;
    }

    private String ztykousinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKOUSINKBN)
    public String getZtykousinkbn() {
        return ztykousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykousinkbn(String pZtykousinkbn) {
        ztykousinkbn = pZtykousinkbn;
    }

    private String ztykusnmetkyksykipjyutuym;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKUSNMETKYKSYKIPJYUTUYM)
    public String getZtykusnmetkyksykipjyutuym() {
        return ztykusnmetkyksykipjyutuym;
    }

    public void setZtykusnmetkyksykipjyutuym(String pZtykusnmetkyksykipjyutuym) {
        ztykusnmetkyksykipjyutuym = pZtykusnmetkyksykipjyutuym;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztypmenhukakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYPMENHUKAKBN)
    public String getZtypmenhukakbn() {
        return ztypmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtypmenhukakbn(String pZtypmenhukakbn) {
        ztypmenhukakbn = pZtypmenhukakbn;
    }

    private String ztypmenkbnv2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYPMENKBNV2)
    public String getZtypmenkbnv2() {
        return ztypmenkbnv2;
    }

    public void setZtypmenkbnv2(String pZtypmenkbnv2) {
        ztypmenkbnv2 = pZtypmenkbnv2;
    }

    private String ztyketteikijyunkanwakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKETTEIKIJYUNKANWAKBN)
    public String getZtyketteikijyunkanwakbn() {
        return ztyketteikijyunkanwakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyketteikijyunkanwakbn(String pZtyketteikijyunkanwakbn) {
        ztyketteikijyunkanwakbn = pZtyketteikijyunkanwakbn;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztytokuyakukigousedaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUYAKUKIGOUSEDAIKBN)
    public String getZtytokuyakukigousedaikbn() {
        return ztytokuyakukigousedaikbn;
    }

    public void setZtytokuyakukigousedaikbn(String pZtytokuyakukigousedaikbn) {
        ztytokuyakukigousedaikbn = pZtytokuyakukigousedaikbn;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztystdssnskbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSTDSSNSKBN)
    public String getZtystdssnskbn() {
        return ztystdssnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssnskbn(String pZtystdssnskbn) {
        ztystdssnskbn = pZtystdssnskbn;
    }

    private String ztysotodasikousinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSOTODASIKOUSINKBN)
    public String getZtysotodasikousinkbn() {
        return ztysotodasikousinkbn;
    }

    public void setZtysotodasikousinkbn(String pZtysotodasikousinkbn) {
        ztysotodasikousinkbn = pZtysotodasikousinkbn;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztyyobiv5;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private String ztyqpackhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYQPACKHYJ)
    public String getZtyqpackhyj() {
        return ztyqpackhyj;
    }

    public void setZtyqpackhyj(String pZtyqpackhyj) {
        ztyqpackhyj = pZtyqpackhyj;
    }

    private String ztybunkatukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYBUNKATUKBN)
    public String getZtybunkatukbn() {
        return ztybunkatukbn;
    }

    public void setZtybunkatukbn(String pZtybunkatukbn) {
        ztybunkatukbn = pZtybunkatukbn;
    }

    private String ztytenkanhosyouminaosikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTENKANHOSYOUMINAOSIKBN)
    public String getZtytenkanhosyouminaosikbn() {
        return ztytenkanhosyouminaosikbn;
    }

    public void setZtytenkanhosyouminaosikbn(String pZtytenkanhosyouminaosikbn) {
        ztytenkanhosyouminaosikbn = pZtytenkanhosyouminaosikbn;
    }

    private String ztykousinmaesiharaihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKOUSINMAESIHARAIHYJ)
    public String getZtykousinmaesiharaihyj() {
        return ztykousinmaesiharaihyj;
    }

    public void setZtykousinmaesiharaihyj(String pZtykousinmaesiharaihyj) {
        ztykousinmaesiharaihyj = pZtykousinmaesiharaihyj;
    }

    private String ztydouitunyuuinno;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYDOUITUNYUUINNO)
    public String getZtydouitunyuuinno() {
        return ztydouitunyuuinno;
    }

    public void setZtydouitunyuuinno(String pZtydouitunyuuinno) {
        ztydouitunyuuinno = pZtydouitunyuuinno;
    }

    private String ztysyujyutujinyuuinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYUJYUTUJINYUUINKBN)
    public String getZtysyujyutujinyuuinkbn() {
        return ztysyujyutujinyuuinkbn;
    }

    public void setZtysyujyutujinyuuinkbn(String pZtysyujyutujinyuuinkbn) {
        ztysyujyutujinyuuinkbn = pZtysyujyutujinyuuinkbn;
    }

    private String ztysyujyutusyuruikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYUJYUTUSYURUIKBN)
    public String getZtysyujyutusyuruikbn() {
        return ztysyujyutusyuruikbn;
    }

    public void setZtysyujyutusyuruikbn(String pZtysyujyutusyuruikbn) {
        ztysyujyutusyuruikbn = pZtysyujyutusyuruikbn;
    }

    private String ztygannyuuinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGANNYUUINKBN)
    public String getZtygannyuuinkbn() {
        return ztygannyuuinkbn;
    }

    public void setZtygannyuuinkbn(String pZtygannyuuinkbn) {
        ztygannyuuinkbn = pZtygannyuuinkbn;
    }

    private String ztyhokenhoutekiyouhyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYHOKENHOUTEKIYOUHYOUJI)
    public String getZtyhokenhoutekiyouhyouji() {
        return ztyhokenhoutekiyouhyouji;
    }

    public void setZtyhokenhoutekiyouhyouji(String pZtyhokenhoutekiyouhyouji) {
        ztyhokenhoutekiyouhyouji = pZtyhokenhoutekiyouhyouji;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private String ztytokuteijyoutaihushrhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZtytokuteijyoutaihushrhyj() {
        return ztytokuteijyoutaihushrhyj;
    }

    public void setZtytokuteijyoutaihushrhyj(String pZtytokuteijyoutaihushrhyj) {
        ztytokuteijyoutaihushrhyj = pZtytokuteijyoutaihushrhyj;
    }

    private String ztysisyacd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSISYACD)
    public String getZtysisyacd() {
        return ztysisyacd;
    }

    public void setZtysisyacd(String pZtysisyacd) {
        ztysisyacd = pZtysisyacd;
    }

    private String ztysykgycd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztysuuriyouyobiv11;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSUURIYOUYOBIV11)
    public String getZtysuuriyouyobiv11() {
        return ztysuuriyouyobiv11;
    }

    public void setZtysuuriyouyobiv11(String pZtysuuriyouyobiv11) {
        ztysuuriyouyobiv11 = pZtysuuriyouyobiv11;
    }

    private String ztyyoukaigojyoutaikaisiymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOUKAIGOJYOUTAIKAISIYMD)
    public String getZtyyoukaigojyoutaikaisiymd() {
        return ztyyoukaigojyoutaikaisiymd;
    }

    public void setZtyyoukaigojyoutaikaisiymd(String pZtyyoukaigojyoutaikaisiymd) {
        ztyyoukaigojyoutaikaisiymd = pZtyyoukaigojyoutaikaisiymd;
    }

    private String ztyyoukaigojyoutaiendymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOUKAIGOJYOUTAIENDYMD)
    public String getZtyyoukaigojyoutaiendymd() {
        return ztyyoukaigojyoutaiendymd;
    }

    public void setZtyyoukaigojyoutaiendymd(String pZtyyoukaigojyoutaiendymd) {
        ztyyoukaigojyoutaiendymd = pZtyyoukaigojyoutaiendymd;
    }

    private String ztyrendouyousntkjyubbnhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYRENDOUYOUSNTKJYUBBNHYJ)
    public String getZtyrendouyousntkjyubbnhyj() {
        return ztyrendouyousntkjyubbnhyj;
    }

    public void setZtyrendouyousntkjyubbnhyj(String pZtyrendouyousntkjyubbnhyj) {
        ztyrendouyousntkjyubbnhyj = pZtyrendouyousntkjyubbnhyj;
    }

    private String ztymusentakukeiyakukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYMUSENTAKUKEIYAKUKBN)
    public String getZtymusentakukeiyakukbn() {
        return ztymusentakukeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymusentakukeiyakukbn(String pZtymusentakukeiyakukbn) {
        ztymusentakukeiyakukbn = pZtymusentakukeiyakukbn;
    }

    private String ztymaruteiskeijihukahyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYMARUTEISKEIJIHUKAHYJ)
    public String getZtymaruteiskeijihukahyj() {
        return ztymaruteiskeijihukahyj;
    }

    public void setZtymaruteiskeijihukahyj(String pZtymaruteiskeijihukahyj) {
        ztymaruteiskeijihukahyj = pZtymaruteiskeijihukahyj;
    }

    private String ztytoliplhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOLIPLHYJ)
    public String getZtytoliplhyj() {
        return ztytoliplhyj;
    }

    public void setZtytoliplhyj(String pZtytoliplhyj) {
        ztytoliplhyj = pZtytoliplhyj;
    }

    private String ztystdssytikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSTDSSYTIKBN)
    public String getZtystdssytikbn() {
        return ztystdssytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssytikbn(String pZtystdssytikbn) {
        ztystdssytikbn = pZtystdssytikbn;
    }

    private String ztyhisei;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYHISEI)
    public String getZtyhisei() {
        return ztyhisei;
    }

    public void setZtyhisei(String pZtyhisei) {
        ztyhisei = pZtyhisei;
    }

    private Integer ztysuuriyobin9;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSUURIYOBIN9)
    public Integer getZtysuuriyobin9() {
        return ztysuuriyobin9;
    }

    public void setZtysuuriyobin9(Integer pZtysuuriyobin9) {
        ztysuuriyobin9 = pZtysuuriyobin9;
    }

    private Long ztysaigaisibousiharaikngk;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSAIGAISIBOUSIHARAIKNGK)
    public Long getZtysaigaisibousiharaikngk() {
        return ztysaigaisibousiharaikngk;
    }

    public void setZtysaigaisibousiharaikngk(Long pZtysaigaisibousiharaikngk) {
        ztysaigaisibousiharaikngk = pZtysaigaisibousiharaikngk;
    }

    private String ztytokuyakuhinen;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUYAKUHINEN)
    public String getZtytokuyakuhinen() {
        return ztytokuyakuhinen;
    }

    public void setZtytokuyakuhinen(String pZtytokuyakuhinen) {
        ztytokuyakuhinen = pZtytokuyakuhinen;
    }

    private Integer ztygnykbttryukyuhkntusnkisu;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGNYKBTTRYUKYUHKNTUSNKISU)
    public Integer getZtygnykbttryukyuhkntusnkisu() {
        return ztygnykbttryukyuhkntusnkisu;
    }

    public void setZtygnykbttryukyuhkntusnkisu(Integer pZtygnykbttryukyuhkntusnkisu) {
        ztygnykbttryukyuhkntusnkisu = pZtygnykbttryukyuhkntusnkisu;
    }

    private String ztygansyuruikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGANSYURUIKBN)
    public String getZtygansyuruikbn() {
        return ztygansyuruikbn;
    }

    public void setZtygansyuruikbn(String pZtygansyuruikbn) {
        ztygansyuruikbn = pZtygansyuruikbn;
    }

    private String ztyganyakubutusyuruikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGANYAKUBUTUSYURUIKBN)
    public String getZtyganyakubutusyuruikbn() {
        return ztyganyakubutusyuruikbn;
    }

    public void setZtyganyakubutusyuruikbn(String pZtyganyakubutusyuruikbn) {
        ztyganyakubutusyuruikbn = pZtyganyakubutusyuruikbn;
    }

    private String ztysyuuroukigjyujtjyutikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYUUROUKIGJYUJTJYUTIKBN)
    public String getZtysyuuroukigjyujtjyutikbn() {
        return ztysyuuroukigjyujtjyutikbn;
    }

    public void setZtysyuuroukigjyujtjyutikbn(String pZtysyuuroukigjyujtjyutikbn) {
        ztysyuuroukigjyujtjyutikbn = pZtysyuuroukigjyujtjyutikbn;
    }

    private String ztysyuuroukigjyujtgeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYUUROUKIGJYUJTGENINKBN)
    public String getZtysyuuroukigjyujtgeninkbn() {
        return ztysyuuroukigjyujtgeninkbn;
    }

    public void setZtysyuuroukigjyujtgeninkbn(String pZtysyuuroukigjyujtgeninkbn) {
        ztysyuuroukigjyujtgeninkbn = pZtysyuuroukigjyujtgeninkbn;
    }

    private String ztykigjyujtjyoutaigeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKIGJYUJTJYOUTAIGENINKBN)
    public String getZtykigjyujtjyoutaigeninkbn() {
        return ztykigjyujtjyoutaigeninkbn;
    }

    public void setZtykigjyujtjyoutaigeninkbn(String pZtykigjyujtjyoutaigeninkbn) {
        ztykigjyujtjyoutaigeninkbn = pZtykigjyujtjyoutaigeninkbn;
    }

    private String ztysykmtssyukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYKMTSSYUKAHIKBN)
    public String getZtysykmtssyukahikbn() {
        return ztysykmtssyukahikbn;
    }

    public void setZtysykmtssyukahikbn(String pZtysykmtssyukahikbn) {
        ztysykmtssyukahikbn = pZtysykmtssyukahikbn;
    }

    private String ztyfktrsmtkahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYFKTRSMTKAHIKBN)
    public String getZtyfktrsmtkahikbn() {
        return ztyfktrsmtkahikbn;
    }

    public void setZtyfktrsmtkahikbn(String pZtyfktrsmtkahikbn) {
        ztyfktrsmtkahikbn = pZtyfktrsmtkahikbn;
    }

    private String ztyhokoukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYHOKOUKAHIKBN)
    public String getZtyhokoukahikbn() {
        return ztyhokoukahikbn;
    }

    public void setZtyhokoukahikbn(String pZtyhokoukahikbn) {
        ztyhokoukahikbn = pZtyhokoukahikbn;
    }

    private String ztynyykkahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYNYYKKAHIKBN)
    public String getZtynyykkahikbn() {
        return ztynyykkahikbn;
    }

    public void setZtynyykkahikbn(String pZtynyykkahikbn) {
        ztynyykkahikbn = pZtynyykkahikbn;
    }

    private String ztyihukutyakudatukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYIHUKUTYAKUDATUKAHIKBN)
    public String getZtyihukutyakudatukahikbn() {
        return ztyihukutyakudatukahikbn;
    }

    public void setZtyihukutyakudatukahikbn(String pZtyihukutyakudatukahikbn) {
        ztyihukutyakudatukahikbn = pZtyihukutyakudatukahikbn;
    }

    private String ztyngerkahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYNGERKAHIKBN)
    public String getZtyngerkahikbn() {
        return ztyngerkahikbn;
    }

    public void setZtyngerkahikbn(String pZtyngerkahikbn) {
        ztyngerkahikbn = pZtyngerkahikbn;
    }

    private String ztyseiketuseiyoukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSEIKETUSEIYOUKAHIKBN)
    public String getZtyseiketuseiyoukahikbn() {
        return ztyseiketuseiyoukahikbn;
    }

    public void setZtyseiketuseiyoukahikbn(String pZtyseiketuseiyoukahikbn) {
        ztyseiketuseiyoukahikbn = pZtyseiketuseiyoukahikbn;
    }

    private String ztynintisyougeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYNINTISYOUGENINKBN)
    public String getZtynintisyougeninkbn() {
        return ztynintisyougeninkbn;
    }

    public void setZtynintisyougeninkbn(String pZtynintisyougeninkbn) {
        ztynintisyougeninkbn = pZtynintisyougeninkbn;
    }

    private String ztysyuruhnujyujtjyutikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSYURUHNUJYUJTJYUTIKBN)
    public String getZtysyuruhnujyujtjyutikbn() {
        return ztysyuruhnujyujtjyutikbn;
    }

    public void setZtysyuruhnujyujtjyutikbn(String pZtysyuruhnujyujtjyutikbn) {
        ztysyuruhnujyujtjyutikbn = pZtysyuruhnujyujtjyutikbn;
    }

    private String ztytokuteisyougaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYTOKUTEISYOUGAIKBN)
    public String getZtytokuteisyougaikbn() {
        return ztytokuteisyougaikbn;
    }

    public void setZtytokuteisyougaikbn(String pZtytokuteisyougaikbn) {
        ztytokuteisyougaikbn = pZtytokuteisyougaikbn;
    }

    private String ztydatakanrino2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYDATAKANRINO2)
    public String getZtydatakanrino2() {
        return ztydatakanrino2;
    }

    public void setZtydatakanrino2(String pZtydatakanrino2) {
        ztydatakanrino2 = pZtydatakanrino2;
    }

    private String ztydatakanrino3;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYDATAKANRINO3)
    public String getZtydatakanrino3() {
        return ztydatakanrino3;
    }

    public void setZtydatakanrino3(String pZtydatakanrino3) {
        ztydatakanrino3 = pZtydatakanrino3;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztybluekeizokuhyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYBLUEKEIZOKUHYOUJI)
    public String getZtybluekeizokuhyouji() {
        return ztybluekeizokuhyouji;
    }

    public void setZtybluekeizokuhyouji(String pZtybluekeizokuhyouji) {
        ztybluekeizokuhyouji = pZtybluekeizokuhyouji;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyzyrthntiyustatuskbnx2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYZYRTHNTIYUSTATUSKBNX2)
    public String getZtyzyrthntiyustatuskbnx2() {
        return ztyzyrthntiyustatuskbnx2;
    }

    public void setZtyzyrthntiyustatuskbnx2(String pZtyzyrthntiyustatuskbnx2) {
        ztyzyrthntiyustatuskbnx2 = pZtyzyrthntiyustatuskbnx2;
    }

    private String ztyzyrthntiyustatuskbnx3;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYZYRTHNTIYUSTATUSKBNX3)
    public String getZtyzyrthntiyustatuskbnx3() {
        return ztyzyrthntiyustatuskbnx3;
    }

    public void setZtyzyrthntiyustatuskbnx3(String pZtyzyrthntiyustatuskbnx3) {
        ztyzyrthntiyustatuskbnx3 = pZtyzyrthntiyustatuskbnx3;
    }

    private String ztyzyrthntiyustatuskbnx4;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYZYRTHNTIYUSTATUSKBNX4)
    public String getZtyzyrthntiyustatuskbnx4() {
        return ztyzyrthntiyustatuskbnx4;
    }

    public void setZtyzyrthntiyustatuskbnx4(String pZtyzyrthntiyustatuskbnx4) {
        ztyzyrthntiyustatuskbnx4 = pZtyzyrthntiyustatuskbnx4;
    }

    private String ztyzyrthntiyustatuskbnx5;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYZYRTHNTIYUSTATUSKBNX5)
    public String getZtyzyrthntiyustatuskbnx5() {
        return ztyzyrthntiyustatuskbnx5;
    }

    public void setZtyzyrthntiyustatuskbnx5(String pZtyzyrthntiyustatuskbnx5) {
        ztyzyrthntiyustatuskbnx5 = pZtyzyrthntiyustatuskbnx5;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyknkuzusnzyrtx2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKNKUZUSNZYRTX2)
    public String getZtyknkuzusnzyrtx2() {
        return ztyknkuzusnzyrtx2;
    }

    public void setZtyknkuzusnzyrtx2(String pZtyknkuzusnzyrtx2) {
        ztyknkuzusnzyrtx2 = pZtyknkuzusnzyrtx2;
    }

    private String ztysinkeiyakujivithkhyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSINKEIYAKUJIVITHKHYOUJI)
    public String getZtysinkeiyakujivithkhyouji() {
        return ztysinkeiyakujivithkhyouji;
    }

    public void setZtysinkeiyakujivithkhyouji(String pZtysinkeiyakujivithkhyouji) {
        ztysinkeiyakujivithkhyouji = pZtysinkeiyakujivithkhyouji;
    }

    private String ztypwrbksidhitekiyouhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYPWRBKSIDHITEKIYOUHYJ)
    public String getZtypwrbksidhitekiyouhyj() {
        return ztypwrbksidhitekiyouhyj;
    }

    public void setZtypwrbksidhitekiyouhyj(String pZtypwrbksidhitekiyouhyj) {
        ztypwrbksidhitekiyouhyj = pZtypwrbksidhitekiyouhyj;
    }

    private String ztykykymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztysuuriyouyobin4;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSUURIYOUYOBIN4)
    public String getZtysuuriyouyobin4() {
        return ztysuuriyouyobin4;
    }

    public void setZtysuuriyouyobin4(String pZtysuuriyouyobin4) {
        ztysuuriyouyobin4 = pZtysuuriyouyobin4;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private Long ztygaikadatesiharais;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGAIKADATESIHARAIS)
    public Long getZtygaikadatesiharais() {
        return ztygaikadatesiharais;
    }

    public void setZtygaikadatesiharais(Long pZtygaikadatesiharais) {
        ztygaikadatesiharais = pZtygaikadatesiharais;
    }

    private Long ztygaikadatesyukeiyakus;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGAIKADATESYUKEIYAKUS)
    public Long getZtygaikadatesyukeiyakus() {
        return ztygaikadatesyukeiyakus;
    }

    public void setZtygaikadatesyukeiyakus(Long pZtygaikadatesyukeiyakus) {
        ztygaikadatesyukeiyakus = pZtygaikadatesyukeiyakus;
    }

    private Long ztygaikadatesyukeiyakup;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYGAIKADATESYUKEIYAKUP)
    public Long getZtygaikadatesyukeiyakup() {
        return ztygaikadatesyukeiyakup;
    }

    public void setZtygaikadatesyukeiyakup(Long pZtygaikadatesyukeiyakup) {
        ztygaikadatesyukeiyakup = pZtygaikadatesyukeiyakup;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private String ztysuuriyouyobin10;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYSUURIYOUYOBIN10)
    public String getZtysuuriyouyobin10() {
        return ztysuuriyouyobin10;
    }

    public void setZtysuuriyouyobin10(String pZtysuuriyouyobin10) {
        ztysuuriyouyobin10 = pZtysuuriyouyobin10;
    }

    private String ztyyobiv10x2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV10X2)
    public String getZtyyobiv10x2() {
        return ztyyobiv10x2;
    }

    public void setZtyyobiv10x2(String pZtyyobiv10x2) {
        ztyyobiv10x2 = pZtyyobiv10x2;
    }

    private Long ztymvatyouseigow;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYMVATYOUSEIGOW)
    public Long getZtymvatyouseigow() {
        return ztymvatyouseigow;
    }

    public void setZtymvatyouseigow(Long pZtymvatyouseigow) {
        ztymvatyouseigow = pZtymvatyouseigow;
    }

    private Long ztymvakeisanjisknnjynbkn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYMVAKEISANJISKNNJYNBKN)
    public Long getZtymvakeisanjisknnjynbkn() {
        return ztymvakeisanjisknnjynbkn;
    }

    public void setZtymvakeisanjisknnjynbkn(Long pZtymvakeisanjisknnjynbkn) {
        ztymvakeisanjisknnjynbkn = pZtymvakeisanjisknnjynbkn;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }
}