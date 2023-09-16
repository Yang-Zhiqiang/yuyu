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
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.id.PKZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.meta.GenQZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkRn;

/**
 * 給付金支払状況連絡Fテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KyhknShrJyoukyouRnrkRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KyhknShrJyoukyouRnrkRn}</td><td colspan="3">給付金支払状況連絡Fテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_KyhknShrJyoukyouRnrkRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv12 zrnyobiv12}</td><td>（連携用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyukgu zrntksyukgu}</td><td>（連携用）特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakugatakbn zrntokuyakugatakbn}</td><td>（連携用）特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukisi zrntokuyakukisi}</td><td>（連携用）特約期始</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuutohukakbn zrntyuutohukakbn}</td><td>（連携用）中途付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoukataikbn zrnhyoukataikbn}</td><td>（連携用）標下体区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaisisyatodouhukencd zrnatukaisisyatodouhukencd}</td><td>（連携用）扱支社都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakusinkyuukbn zrntokuyakusinkyuukbn}</td><td>（連携用）特約新旧区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkykdai2hihokensyahyj zrntkykdai2hihokensyahyj}</td><td>（連携用）特約第２被保険者表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteisippeisethyj zrntokuteisippeisethyj}</td><td>（連携用）特定疾病セット表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyusyousyaseibetukbn zrnjyusyousyaseibetukbn}</td><td>（連携用）受傷者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokujyusyousyakbn zrnkazokujyusyousyakbn}</td><td>（連携用）家族受傷者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunen zrnkeiyakunen}</td><td>（連携用）契約年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmannenreihyj zrnmannenreihyj}</td><td>（連携用）満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyuuhukbn zrnkyuuhukbn}</td><td>（連携用）給付区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaijyoutaikbn zrnsiharaijyoutaikbn}</td><td>（連携用）支払状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouincd zrnsyouincd}</td><td>（連携用）消因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikohasseiymd2 zrnjikohasseiymd2}</td><td>（連携用）事故発生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaikoteiymd zrnsyougaikoteiymd}</td><td>（連携用）傷害固定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuinymd zrnnyuuinymd}</td><td>（連携用）入院年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrymd zrnshrymd}</td><td>（連携用）支払年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyuuhuwariai zrnkyuuhuwariai}</td><td>（連携用）給付割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaikingakun9 zrnsiharaikingakun9}</td><td>（連携用）支払金額Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkyoukaihoukokuyoukingaku zrnkyoukaihoukokuyoukingaku}</td><td>（連携用）協会報告用金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntuuinkakujyuuhukakbn zrntuuinkakujyuuhukakbn}</td><td>（連携用）通院カク充付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkangohukahyj zrnkangohukahyj}</td><td>（連携用）看護付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonsyoukyuuhukinkbn zrnsonsyoukyuuhukinkbn}</td><td>（連携用）損傷給付金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukoudosyougaicd zrnsiboukoudosyougaicd}</td><td>（連携用）死亡高度障害コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokikyuuhutandokushrhyj zrnsyokikyuuhutandokushrhyj}</td><td>（連携用）初期給付単独支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuseikyuuhukbn zrnkakuseikyuuhukbn}</td><td>（連携用）カク成給付区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsoukikeakyuuhutuusankisu zrnsoukikeakyuuhutuusankisu}</td><td>（連携用）早期ケア給付通算回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyonendokyuuhuwariai zrnsyonendokyuuhuwariai}</td><td>（連携用）初年度給付割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyonendosiharaihyj zrnsyonendosiharaihyj}</td><td>（連携用）初年度支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x2 zrnyobiv4x2}</td><td>（連携用）予備項目Ｖ４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousingohasseihyj zrnkousingohasseihyj}</td><td>（連携用）更新後発生表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeicd1 zrnbyoumeicd1}</td><td>（連携用）病名コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeicd2 zrnbyoumeicd2}</td><td>（連携用）病名コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigaigenincd zrnsaigaigenincd}</td><td>（連携用）災害原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitoukyuugou zrnsyougaitoukyuugou}</td><td>（連携用）障害等級号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyujyutucd zrnsyujyutucd}</td><td>（連携用）手術コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyujyutumeicd zrnsyujyutumeicd}</td><td>（連携用）手術名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuinkangogeninkbn zrntuuinkangogeninkbn}</td><td>（連携用）通院看護原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnundoukisonsyoukbn zrnundoukisonsyoukbn}</td><td>（連携用）運動器損傷区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganmensonsyoukbn zrnganmensonsyoukbn}</td><td>（連携用）顔面損傷区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonsyougeninkbn zrnsonsyougeninkbn}</td><td>（連携用）損傷原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikensportskbn zrnkikensportskbn}</td><td>（連携用）危険スポーツ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x2 zrnyobiv2x2}</td><td>（連携用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharainissuukbn zrnsiharainissuukbn}</td><td>（連携用）支払日数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuseikatakbn zrnkakuseikatakbn}</td><td>（連携用）カク成型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeirokbn zrnbosyuukeirokbn}</td><td>（連携用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpohyj zrnpmenhutanpohyj}</td><td>（連携用）Ｐ免不担保表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinkbn zrnkousinkbn}</td><td>（連携用）更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkusnmetkyksykipjyutuym zrnkusnmetkyksykipjyutuym}</td><td>（連携用）更新前特約初回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeiyousinsakbn zrntoukeiyousinsakbn}</td><td>（連携用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhukakbn zrnpmenhukakbn}</td><td>（連携用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbnv2 zrnpmenkbnv2}</td><td>（連携用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketteikijyunkanwakbn zrnketteikijyunkanwakbn}</td><td>（連携用）決定基準緩和区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukigousedaikbn zrntokuyakukigousedaikbn}</td><td>（連携用）特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssnskbn zrnstdssnskbn}</td><td>（連携用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasikousinkbn zrnsotodasikousinkbn}</td><td>（連携用）外出更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnqpackhyj zrnqpackhyj}</td><td>（連携用）Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbunkatukbn zrnbunkatukbn}</td><td>（連携用）分割区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanhosyouminaosikbn zrntenkanhosyouminaosikbn}</td><td>（連携用）転換保障見直区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinmaesiharaihyj zrnkousinmaesiharaihyj}</td><td>（連携用）更新前支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndouitunyuuinno zrndouitunyuuinno}</td><td>（連携用）同一入院番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyujyutujinyuuinkbn zrnsyujyutujinyuuinkbn}</td><td>（連携用）手術時入院区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyujyutusyuruikbn zrnsyujyutusyuruikbn}</td><td>（連携用）手術種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngannyuuinkbn zrngannyuuinkbn}</td><td>（連携用）がん入院区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokenhoutekiyouhyouji zrnhokenhoutekiyouhyouji}</td><td>（連携用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteijyoutaihushrhyj zrntokuteijyoutaihushrhyj}</td><td>（連携用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisyacd zrnsisyacd}</td><td>（連携用）支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobiv11 zrnsuuriyouyobiv11}</td><td>（連携用）数理用予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoukaigojyoutaikaisiymd zrnyoukaigojyoutaikaisiymd}</td><td>（連携用）要介護状態開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoukaigojyoutaiendymd zrnyoukaigojyoutaiendymd}</td><td>（連携用）要介護状態終了年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyousntkjyubbnhyj zrnrendouyousntkjyubbnhyj}</td><td>（連携用）連動用新特条部分表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusentakukeiyakukbn zrnmusentakukeiyakukbn}</td><td>（連携用）無選択契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteiskeijihukahyj zrnmaruteiskeijihukahyj}</td><td>（連携用）マル定新契約時付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoliplhyj zrntoliplhyj}</td><td>（連携用）ＴＯＬＩＰＬ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssytikbn zrnstdssytikbn}</td><td>（連携用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhisei zrnhisei}</td><td>（連携用）被性</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyobin9 zrnsuuriyobin9}</td><td>（連携用）数理予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsaigaisibousiharaikngk zrnsaigaisibousiharaikngk}</td><td>（連携用）災害死亡支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokuyakuhinen zrntokuyakuhinen}</td><td>（連携用）特約被年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnykbttryukyuhkntusnkisu zrngnykbttryukyuhkntusnkisu}</td><td>（連携用）がん薬物治療給付金通算回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngansyuruikbn zrngansyuruikbn}</td><td>（連携用）がん種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnganyakubutusyuruikbn zrnganyakubutusyuruikbn}</td><td>（連携用）がん薬物種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuuroukigjyujtjyutikbn zrnsyuuroukigjyujtjyutikbn}</td><td>（連携用）就労介護充実状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuuroukigjyujtgeninkbn zrnsyuuroukigjyujtgeninkbn}</td><td>（連携用）就労介護充実原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigjyujtjyoutaigeninkbn zrnkigjyujtjyoutaigeninkbn}</td><td>（連携用）介護充実状態原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykmtssyukahikbn zrnsykmtssyukahikbn}</td><td>（連携用）食物摂取可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfktrsmtkahikbn zrnfktrsmtkahikbn}</td><td>（連携用）拭き取り始末可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokoukahikbn zrnhokoukahikbn}</td><td>（連携用）歩行可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyykkahikbn zrnnyykkahikbn}</td><td>（連携用）入浴可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnihukutyakudatukahikbn zrnihukutyakudatukahikbn}</td><td>（連携用）衣服着脱可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnngerkahikbn zrnngerkahikbn}</td><td>（連携用）寝返り可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseiketuseiyoukahikbn zrnseiketuseiyoukahikbn}</td><td>（連携用）清潔整容可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnintisyougeninkbn zrnnintisyougeninkbn}</td><td>（連携用）認知症原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuruhnujyujtjyutikbn zrnsyuruhnujyujtjyutikbn}</td><td>（連携用）就労不能充実状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteisyougaikbn zrntokuteisyougaikbn}</td><td>（連携用）特定障害区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino2 zrndatakanrino2}</td><td>（連携用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino3 zrndatakanrino3}</td><td>（連携用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluekeizokuhyouji zrnbluekeizokuhyouji}</td><td>（連携用）Ｂｌｕｅ継続表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbn zrnzyrthntiyustatuskbn}</td><td>（連携用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx2 zrnzyrthntiyustatuskbnx2}</td><td>（連携用）乗率判定用ステータス区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx3 zrnzyrthntiyustatuskbnx3}</td><td>（連携用）乗率判定用ステータス区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx4 zrnzyrthntiyustatuskbnx4}</td><td>（連携用）乗率判定用ステータス区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx5 zrnzyrthntiyustatuskbnx5}</td><td>（連携用）乗率判定用ステータス区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrtx2 zrnknkuzusnzyrtx2}</td><td>（連携用）健康増進乗率＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkeiyakujivithkhyouji zrnsinkeiyakujivithkhyouji}</td><td>（連携用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwrbksidhitekiyouhyj zrnpwrbksidhitekiyouhyj}</td><td>（連携用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin4 zrnsuuriyouyobin4}</td><td>（連携用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngaikadatesiharais zrngaikadatesiharais}</td><td>（連携用）外貨建支払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakus zrngaikadatesyukeiyakus}</td><td>（連携用）外貨建主契約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakup zrngaikadatesyukeiyakup}</td><td>（連携用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10 zrnsuuriyouyobin10}</td><td>（連携用）数理用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x2 zrnyobiv10x2}</td><td>（連携用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseigow zrnmvatyouseigow}</td><td>（連携用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmvakeisanjisknnjynbkn zrnmvakeisanjisknnjynbkn}</td><td>（連携用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KyhknShrJyoukyouRnrkRn
 * @see     PKZT_KyhknShrJyoukyouRnrkRn
 * @see     QZT_KyhknShrJyoukyouRnrkRn
 * @see     GenQZT_KyhknShrJyoukyouRnrkRn
 */
@MappedSuperclass
@Table(name=GenZT_KyhknShrJyoukyouRnrkRn.TABLE_NAME)
@IdClass(value=PKZT_KyhknShrJyoukyouRnrkRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KyhknShrJyoukyouRnrkRn extends AbstractExDBEntityForZDB<ZT_KyhknShrJyoukyouRnrkRn, PKZT_KyhknShrJyoukyouRnrkRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KyhknShrJyoukyouRnrkRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYOBIV12               = "zrnyobiv12";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNTKSYUKGU              = "zrntksyukgu";
    public static final String ZRNTOKUYAKUGATAKBN       = "zrntokuyakugatakbn";
    public static final String ZRNTOKUYAKUKISI          = "zrntokuyakukisi";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNTYUUTOHUKAKBN         = "zrntyuutohukakbn";
    public static final String ZRNHYOUKATAIKBN          = "zrnhyoukataikbn";
    public static final String ZRNATUKAISISYATODOUHUKENCD = "zrnatukaisisyatodouhukencd";
    public static final String ZRNTOKUYAKUSINKYUUKBN    = "zrntokuyakusinkyuukbn";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNTKYKDAI2HIHOKENSYAHYJ = "zrntkykdai2hihokensyahyj";
    public static final String ZRNTOKUTEISIPPEISETHYJ   = "zrntokuteisippeisethyj";
    public static final String ZRNJYUSYOUSYASEIBETUKBN  = "zrnjyusyousyaseibetukbn";
    public static final String ZRNKAZOKUJYUSYOUSYAKBN   = "zrnkazokujyusyousyakbn";
    public static final String ZRNKEIYAKUNEN            = "zrnkeiyakunen";
    public static final String ZRNMANNENREIHYJ          = "zrnmannenreihyj";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNKYUUHUKBN             = "zrnkyuuhukbn";
    public static final String ZRNSIHARAIJYOUTAIKBN     = "zrnsiharaijyoutaikbn";
    public static final String ZRNSYOUINCD              = "zrnsyouincd";
    public static final String ZRNJIKOHASSEIYMD2        = "zrnjikohasseiymd2";
    public static final String ZRNSYOUGAIKOTEIYMD       = "zrnsyougaikoteiymd";
    public static final String ZRNNYUUINYMD             = "zrnnyuuinymd";
    public static final String ZRNSHRYMD                = "zrnshrymd";
    public static final String ZRNKYUUHUWARIAI          = "zrnkyuuhuwariai";
    public static final String ZRNSIHARAIKINGAKUN9      = "zrnsiharaikingakun9";
    public static final String ZRNKYOUKAIHOUKOKUYOUKINGAKU = "zrnkyoukaihoukokuyoukingaku";
    public static final String ZRNTUUINKAKUJYUUHUKAKBN  = "zrntuuinkakujyuuhukakbn";
    public static final String ZRNKANGOHUKAHYJ          = "zrnkangohukahyj";
    public static final String ZRNSONSYOUKYUUHUKINKBN   = "zrnsonsyoukyuuhukinkbn";
    public static final String ZRNSIBOUKOUDOSYOUGAICD   = "zrnsiboukoudosyougaicd";
    public static final String ZRNSYOKIKYUUHUTANDOKUSHRHYJ = "zrnsyokikyuuhutandokushrhyj";
    public static final String ZRNKAKUSEIKYUUHUKBN      = "zrnkakuseikyuuhukbn";
    public static final String ZRNSOUKIKEAKYUUHUTUUSANKISU = "zrnsoukikeakyuuhutuusankisu";
    public static final String ZRNSYONENDOKYUUHUWARIAI  = "zrnsyonendokyuuhuwariai";
    public static final String ZRNSYONENDOSIHARAIHYJ    = "zrnsyonendosiharaihyj";
    public static final String ZRNYOBIV4X2              = "zrnyobiv4x2";
    public static final String ZRNKOUSINGOHASSEIHYJ     = "zrnkousingohasseihyj";
    public static final String ZRNBYOUMEICD1            = "zrnbyoumeicd1";
    public static final String ZRNBYOUMEICD2            = "zrnbyoumeicd2";
    public static final String ZRNSAIGAIGENINCD         = "zrnsaigaigenincd";
    public static final String ZRNSYOUGAITOUKYUUGOU     = "zrnsyougaitoukyuugou";
    public static final String ZRNSYUJYUTUCD            = "zrnsyujyutucd";
    public static final String ZRNSYUJYUTUMEICD         = "zrnsyujyutumeicd";
    public static final String ZRNTUUINKANGOGENINKBN    = "zrntuuinkangogeninkbn";
    public static final String ZRNUNDOUKISONSYOUKBN     = "zrnundoukisonsyoukbn";
    public static final String ZRNGANMENSONSYOUKBN      = "zrnganmensonsyoukbn";
    public static final String ZRNSONSYOUGENINKBN       = "zrnsonsyougeninkbn";
    public static final String ZRNKIKENSPORTSKBN        = "zrnkikensportskbn";
    public static final String ZRNYOBIV2X2              = "zrnyobiv2x2";
    public static final String ZRNSIHARAINISSUUKBN      = "zrnsiharainissuukbn";
    public static final String ZRNKAKUSEIKATAKBN        = "zrnkakuseikatakbn";
    public static final String ZRNBOSYUUKEIROKBN        = "zrnbosyuukeirokbn";
    public static final String ZRNPMENHUTANPOHYJ        = "zrnpmenhutanpohyj";
    public static final String ZRNKOUSINKBN             = "zrnkousinkbn";
    public static final String ZRNKUSNMETKYKSYKIPJYUTUYM = "zrnkusnmetkyksykipjyutuym";
    public static final String ZRNTOUKEIYOUSINSAKBN     = "zrntoukeiyousinsakbn";
    public static final String ZRNPMENHUKAKBN           = "zrnpmenhukakbn";
    public static final String ZRNPMENKBNV2             = "zrnpmenkbnv2";
    public static final String ZRNKETTEIKIJYUNKANWAKBN  = "zrnketteikijyunkanwakbn";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNTOKUYAKUKIGOUSEDAIKBN = "zrntokuyakukigousedaikbn";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSTDSSNSKBN            = "zrnstdssnskbn";
    public static final String ZRNSOTODASIKOUSINKBN     = "zrnsotodasikousinkbn";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
    public static final String ZRNQPACKHYJ              = "zrnqpackhyj";
    public static final String ZRNBUNKATUKBN            = "zrnbunkatukbn";
    public static final String ZRNTENKANHOSYOUMINAOSIKBN = "zrntenkanhosyouminaosikbn";
    public static final String ZRNKOUSINMAESIHARAIHYJ   = "zrnkousinmaesiharaihyj";
    public static final String ZRNDOUITUNYUUINNO        = "zrndouitunyuuinno";
    public static final String ZRNSYUJYUTUJINYUUINKBN   = "zrnsyujyutujinyuuinkbn";
    public static final String ZRNSYUJYUTUSYURUIKBN     = "zrnsyujyutusyuruikbn";
    public static final String ZRNGANNYUUINKBN          = "zrngannyuuinkbn";
    public static final String ZRNHOKENHOUTEKIYOUHYOUJI = "zrnhokenhoutekiyouhyouji";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNTOKUTEIJYOUTAIHUSHRHYJ = "zrntokuteijyoutaihushrhyj";
    public static final String ZRNSISYACD               = "zrnsisyacd";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNSUURIYOUYOBIV11       = "zrnsuuriyouyobiv11";
    public static final String ZRNYOUKAIGOJYOUTAIKAISIYMD = "zrnyoukaigojyoutaikaisiymd";
    public static final String ZRNYOUKAIGOJYOUTAIENDYMD = "zrnyoukaigojyoutaiendymd";
    public static final String ZRNRENDOUYOUSNTKJYUBBNHYJ = "zrnrendouyousntkjyubbnhyj";
    public static final String ZRNMUSENTAKUKEIYAKUKBN   = "zrnmusentakukeiyakukbn";
    public static final String ZRNMARUTEISKEIJIHUKAHYJ  = "zrnmaruteiskeijihukahyj";
    public static final String ZRNTOLIPLHYJ             = "zrntoliplhyj";
    public static final String ZRNSTDSSYTIKBN           = "zrnstdssytikbn";
    public static final String ZRNHISEI                 = "zrnhisei";
    public static final String ZRNSUURIYOBIN9           = "zrnsuuriyobin9";
    public static final String ZRNSAIGAISIBOUSIHARAIKNGK = "zrnsaigaisibousiharaikngk";
    public static final String ZRNTOKUYAKUHINEN         = "zrntokuyakuhinen";
    public static final String ZRNGNYKBTTRYUKYUHKNTUSNKISU = "zrngnykbttryukyuhkntusnkisu";
    public static final String ZRNGANSYURUIKBN          = "zrngansyuruikbn";
    public static final String ZRNGANYAKUBUTUSYURUIKBN  = "zrnganyakubutusyuruikbn";
    public static final String ZRNSYUUROUKIGJYUJTJYUTIKBN = "zrnsyuuroukigjyujtjyutikbn";
    public static final String ZRNSYUUROUKIGJYUJTGENINKBN = "zrnsyuuroukigjyujtgeninkbn";
    public static final String ZRNKIGJYUJTJYOUTAIGENINKBN = "zrnkigjyujtjyoutaigeninkbn";
    public static final String ZRNSYKMTSSYUKAHIKBN      = "zrnsykmtssyukahikbn";
    public static final String ZRNFKTRSMTKAHIKBN        = "zrnfktrsmtkahikbn";
    public static final String ZRNHOKOUKAHIKBN          = "zrnhokoukahikbn";
    public static final String ZRNNYYKKAHIKBN           = "zrnnyykkahikbn";
    public static final String ZRNIHUKUTYAKUDATUKAHIKBN = "zrnihukutyakudatukahikbn";
    public static final String ZRNNGERKAHIKBN           = "zrnngerkahikbn";
    public static final String ZRNSEIKETUSEIYOUKAHIKBN  = "zrnseiketuseiyoukahikbn";
    public static final String ZRNNINTISYOUGENINKBN     = "zrnnintisyougeninkbn";
    public static final String ZRNSYURUHNUJYUJTJYUTIKBN = "zrnsyuruhnujyujtjyutikbn";
    public static final String ZRNTOKUTEISYOUGAIKBN     = "zrntokuteisyougaikbn";
    public static final String ZRNDATAKANRINO2          = "zrndatakanrino2";
    public static final String ZRNDATAKANRINO3          = "zrndatakanrino3";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNBLUEKEIZOKUHYOUJI     = "zrnbluekeizokuhyouji";
    public static final String ZRNZYRTHNTIYUSTATUSKBN   = "zrnzyrthntiyustatuskbn";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX2 = "zrnzyrthntiyustatuskbnx2";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX3 = "zrnzyrthntiyustatuskbnx3";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX4 = "zrnzyrthntiyustatuskbnx4";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX5 = "zrnzyrthntiyustatuskbnx5";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNKNKUZUSNZYRTX2        = "zrnknkuzusnzyrtx2";
    public static final String ZRNSINKEIYAKUJIVITHKHYOUJI = "zrnsinkeiyakujivithkhyouji";
    public static final String ZRNPWRBKSIDHITEKIYOUHYJ  = "zrnpwrbksidhitekiyouhyj";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNSUURIYOUYOBIN4        = "zrnsuuriyouyobin4";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNGAIKADATESIHARAIS     = "zrngaikadatesiharais";
    public static final String ZRNGAIKADATESYUKEIYAKUS  = "zrngaikadatesyukeiyakus";
    public static final String ZRNGAIKADATESYUKEIYAKUP  = "zrngaikadatesyukeiyakup";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNSUURIYOUYOBIN10       = "zrnsuuriyouyobin10";
    public static final String ZRNYOBIV10X2             = "zrnyobiv10x2";
    public static final String ZRNMVATYOUSEIGOW         = "zrnmvatyouseigow";
    public static final String ZRNMVAKEISANJISKNNJYNBKN = "zrnmvakeisanjisknnjynbkn";
    public static final String ZRNYOBIV6                = "zrnyobiv6";

    private final PKZT_KyhknShrJyoukyouRnrkRn primaryKey;

    public GenZT_KyhknShrJyoukyouRnrkRn() {
        primaryKey = new PKZT_KyhknShrJyoukyouRnrkRn();
    }

    public GenZT_KyhknShrJyoukyouRnrkRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_KyhknShrJyoukyouRnrkRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_KyhknShrJyoukyouRnrkRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KyhknShrJyoukyouRnrkRn> getMetaClass() {
        return QZT_KyhknShrJyoukyouRnrkRn.class;
    }

    @Id
    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnyobiv12;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV12)
    public String getZrnyobiv12() {
        return zrnyobiv12;
    }

    public void setZrnyobiv12(String pZrnyobiv12) {
        zrnyobiv12 = pZrnyobiv12;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    private String zrntksyukgu;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTKSYUKGU)
    public String getZrntksyukgu() {
        return zrntksyukgu;
    }

    public void setZrntksyukgu(String pZrntksyukgu) {
        zrntksyukgu = pZrntksyukgu;
    }

    private String zrntokuyakugatakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUYAKUGATAKBN)
    public String getZrntokuyakugatakbn() {
        return zrntokuyakugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakugatakbn(String pZrntokuyakugatakbn) {
        zrntokuyakugatakbn = pZrntokuyakugatakbn;
    }

    private String zrntokuyakukisi;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUYAKUKISI)
    public String getZrntokuyakukisi() {
        return zrntokuyakukisi;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntokuyakukisi(String pZrntokuyakukisi) {
        zrntokuyakukisi = pZrntokuyakukisi;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrntyuutohukakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTYUUTOHUKAKBN)
    public String getZrntyuutohukakbn() {
        return zrntyuutohukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntyuutohukakbn(String pZrntyuutohukakbn) {
        zrntyuutohukakbn = pZrntyuutohukakbn;
    }

    private String zrnhyoukataikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNHYOUKATAIKBN)
    public String getZrnhyoukataikbn() {
        return zrnhyoukataikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhyoukataikbn(String pZrnhyoukataikbn) {
        zrnhyoukataikbn = pZrnhyoukataikbn;
    }

    private String zrnatukaisisyatodouhukencd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNATUKAISISYATODOUHUKENCD)
    public String getZrnatukaisisyatodouhukencd() {
        return zrnatukaisisyatodouhukencd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnatukaisisyatodouhukencd(String pZrnatukaisisyatodouhukencd) {
        zrnatukaisisyatodouhukencd = pZrnatukaisisyatodouhukencd;
    }

    private String zrntokuyakusinkyuukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUYAKUSINKYUUKBN)
    public String getZrntokuyakusinkyuukbn() {
        return zrntokuyakusinkyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakusinkyuukbn(String pZrntokuyakusinkyuukbn) {
        zrntokuyakusinkyuukbn = pZrntokuyakusinkyuukbn;
    }

    private String zrnbsyym;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrntkykdai2hihokensyahyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTKYKDAI2HIHOKENSYAHYJ)
    public String getZrntkykdai2hihokensyahyj() {
        return zrntkykdai2hihokensyahyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntkykdai2hihokensyahyj(String pZrntkykdai2hihokensyahyj) {
        zrntkykdai2hihokensyahyj = pZrntkykdai2hihokensyahyj;
    }

    private String zrntokuteisippeisethyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUTEISIPPEISETHYJ)
    public String getZrntokuteisippeisethyj() {
        return zrntokuteisippeisethyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteisippeisethyj(String pZrntokuteisippeisethyj) {
        zrntokuteisippeisethyj = pZrntokuteisippeisethyj;
    }

    private String zrnjyusyousyaseibetukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNJYUSYOUSYASEIBETUKBN)
    public String getZrnjyusyousyaseibetukbn() {
        return zrnjyusyousyaseibetukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyusyousyaseibetukbn(String pZrnjyusyousyaseibetukbn) {
        zrnjyusyousyaseibetukbn = pZrnjyusyousyaseibetukbn;
    }

    private String zrnkazokujyusyousyakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKAZOKUJYUSYOUSYAKBN)
    public String getZrnkazokujyusyousyakbn() {
        return zrnkazokujyusyousyakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokujyusyousyakbn(String pZrnkazokujyusyousyakbn) {
        zrnkazokujyusyousyakbn = pZrnkazokujyusyousyakbn;
    }

    private String zrnkeiyakunen;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKEIYAKUNEN)
    public String getZrnkeiyakunen() {
        return zrnkeiyakunen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkeiyakunen(String pZrnkeiyakunen) {
        zrnkeiyakunen = pZrnkeiyakunen;
    }

    private String zrnmannenreihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNMANNENREIHYJ)
    public String getZrnmannenreihyj() {
        return zrnmannenreihyj;
    }

    public void setZrnmannenreihyj(String pZrnmannenreihyj) {
        zrnmannenreihyj = pZrnmannenreihyj;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrnkyuuhukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKYUUHUKBN)
    public String getZrnkyuuhukbn() {
        return zrnkyuuhukbn;
    }

    public void setZrnkyuuhukbn(String pZrnkyuuhukbn) {
        zrnkyuuhukbn = pZrnkyuuhukbn;
    }

    private String zrnsiharaijyoutaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSIHARAIJYOUTAIKBN)
    public String getZrnsiharaijyoutaikbn() {
        return zrnsiharaijyoutaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiharaijyoutaikbn(String pZrnsiharaijyoutaikbn) {
        zrnsiharaijyoutaikbn = pZrnsiharaijyoutaikbn;
    }

    private String zrnsyouincd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYOUINCD)
    public String getZrnsyouincd() {
        return zrnsyouincd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyouincd(String pZrnsyouincd) {
        zrnsyouincd = pZrnsyouincd;
    }

    private String zrnjikohasseiymd2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNJIKOHASSEIYMD2)
    public String getZrnjikohasseiymd2() {
        return zrnjikohasseiymd2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnjikohasseiymd2(String pZrnjikohasseiymd2) {
        zrnjikohasseiymd2 = pZrnjikohasseiymd2;
    }

    private String zrnsyougaikoteiymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYOUGAIKOTEIYMD)
    public String getZrnsyougaikoteiymd() {
        return zrnsyougaikoteiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsyougaikoteiymd(String pZrnsyougaikoteiymd) {
        zrnsyougaikoteiymd = pZrnsyougaikoteiymd;
    }

    private String zrnnyuuinymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNNYUUINYMD)
    public String getZrnnyuuinymd() {
        return zrnnyuuinymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnyuuinymd(String pZrnnyuuinymd) {
        zrnnyuuinymd = pZrnnyuuinymd;
    }

    private String zrnshrymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSHRYMD)
    public String getZrnshrymd() {
        return zrnshrymd;
    }

    public void setZrnshrymd(String pZrnshrymd) {
        zrnshrymd = pZrnshrymd;
    }

    private String zrnkyuuhuwariai;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKYUUHUWARIAI)
    public String getZrnkyuuhuwariai() {
        return zrnkyuuhuwariai;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnkyuuhuwariai(String pZrnkyuuhuwariai) {
        zrnkyuuhuwariai = pZrnkyuuhuwariai;
    }

    private Integer zrnsiharaikingakun9;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSIHARAIKINGAKUN9)
    public Integer getZrnsiharaikingakun9() {
        return zrnsiharaikingakun9;
    }

    public void setZrnsiharaikingakun9(Integer pZrnsiharaikingakun9) {
        zrnsiharaikingakun9 = pZrnsiharaikingakun9;
    }

    private Integer zrnkyoukaihoukokuyoukingaku;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKYOUKAIHOUKOKUYOUKINGAKU)
    public Integer getZrnkyoukaihoukokuyoukingaku() {
        return zrnkyoukaihoukokuyoukingaku;
    }

    public void setZrnkyoukaihoukokuyoukingaku(Integer pZrnkyoukaihoukokuyoukingaku) {
        zrnkyoukaihoukokuyoukingaku = pZrnkyoukaihoukokuyoukingaku;
    }

    private String zrntuuinkakujyuuhukakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTUUINKAKUJYUUHUKAKBN)
    public String getZrntuuinkakujyuuhukakbn() {
        return zrntuuinkakujyuuhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuinkakujyuuhukakbn(String pZrntuuinkakujyuuhukakbn) {
        zrntuuinkakujyuuhukakbn = pZrntuuinkakujyuuhukakbn;
    }

    private String zrnkangohukahyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKANGOHUKAHYJ)
    public String getZrnkangohukahyj() {
        return zrnkangohukahyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkangohukahyj(String pZrnkangohukahyj) {
        zrnkangohukahyj = pZrnkangohukahyj;
    }

    private String zrnsonsyoukyuuhukinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSONSYOUKYUUHUKINKBN)
    public String getZrnsonsyoukyuuhukinkbn() {
        return zrnsonsyoukyuuhukinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsonsyoukyuuhukinkbn(String pZrnsonsyoukyuuhukinkbn) {
        zrnsonsyoukyuuhukinkbn = pZrnsonsyoukyuuhukinkbn;
    }

    private String zrnsiboukoudosyougaicd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSIBOUKOUDOSYOUGAICD)
    public String getZrnsiboukoudosyougaicd() {
        return zrnsiboukoudosyougaicd;
    }

    public void setZrnsiboukoudosyougaicd(String pZrnsiboukoudosyougaicd) {
        zrnsiboukoudosyougaicd = pZrnsiboukoudosyougaicd;
    }

    private String zrnsyokikyuuhutandokushrhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYOKIKYUUHUTANDOKUSHRHYJ)
    public String getZrnsyokikyuuhutandokushrhyj() {
        return zrnsyokikyuuhutandokushrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyokikyuuhutandokushrhyj(String pZrnsyokikyuuhutandokushrhyj) {
        zrnsyokikyuuhutandokushrhyj = pZrnsyokikyuuhutandokushrhyj;
    }

    private String zrnkakuseikyuuhukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKAKUSEIKYUUHUKBN)
    public String getZrnkakuseikyuuhukbn() {
        return zrnkakuseikyuuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuseikyuuhukbn(String pZrnkakuseikyuuhukbn) {
        zrnkakuseikyuuhukbn = pZrnkakuseikyuuhukbn;
    }

    private String zrnsoukikeakyuuhutuusankisu;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSOUKIKEAKYUUHUTUUSANKISU)
    public String getZrnsoukikeakyuuhutuusankisu() {
        return zrnsoukikeakyuuhutuusankisu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsoukikeakyuuhutuusankisu(String pZrnsoukikeakyuuhutuusankisu) {
        zrnsoukikeakyuuhutuusankisu = pZrnsoukikeakyuuhutuusankisu;
    }

    private String zrnsyonendokyuuhuwariai;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYONENDOKYUUHUWARIAI)
    public String getZrnsyonendokyuuhuwariai() {
        return zrnsyonendokyuuhuwariai;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyonendokyuuhuwariai(String pZrnsyonendokyuuhuwariai) {
        zrnsyonendokyuuhuwariai = pZrnsyonendokyuuhuwariai;
    }

    private String zrnsyonendosiharaihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYONENDOSIHARAIHYJ)
    public String getZrnsyonendosiharaihyj() {
        return zrnsyonendosiharaihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyonendosiharaihyj(String pZrnsyonendosiharaihyj) {
        zrnsyonendosiharaihyj = pZrnsyonendosiharaihyj;
    }

    private String zrnyobiv4x2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV4X2)
    public String getZrnyobiv4x2() {
        return zrnyobiv4x2;
    }

    public void setZrnyobiv4x2(String pZrnyobiv4x2) {
        zrnyobiv4x2 = pZrnyobiv4x2;
    }

    private String zrnkousingohasseihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKOUSINGOHASSEIHYJ)
    public String getZrnkousingohasseihyj() {
        return zrnkousingohasseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousingohasseihyj(String pZrnkousingohasseihyj) {
        zrnkousingohasseihyj = pZrnkousingohasseihyj;
    }

    private String zrnbyoumeicd1;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNBYOUMEICD1)
    public String getZrnbyoumeicd1() {
        return zrnbyoumeicd1;
    }

    public void setZrnbyoumeicd1(String pZrnbyoumeicd1) {
        zrnbyoumeicd1 = pZrnbyoumeicd1;
    }

    private String zrnbyoumeicd2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNBYOUMEICD2)
    public String getZrnbyoumeicd2() {
        return zrnbyoumeicd2;
    }

    public void setZrnbyoumeicd2(String pZrnbyoumeicd2) {
        zrnbyoumeicd2 = pZrnbyoumeicd2;
    }

    private String zrnsaigaigenincd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSAIGAIGENINCD)
    public String getZrnsaigaigenincd() {
        return zrnsaigaigenincd;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsaigaigenincd(String pZrnsaigaigenincd) {
        zrnsaigaigenincd = pZrnsaigaigenincd;
    }

    private String zrnsyougaitoukyuugou;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYOUGAITOUKYUUGOU)
    public String getZrnsyougaitoukyuugou() {
        return zrnsyougaitoukyuugou;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyougaitoukyuugou(String pZrnsyougaitoukyuugou) {
        zrnsyougaitoukyuugou = pZrnsyougaitoukyuugou;
    }

    private String zrnsyujyutucd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYUJYUTUCD)
    public String getZrnsyujyutucd() {
        return zrnsyujyutucd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyujyutucd(String pZrnsyujyutucd) {
        zrnsyujyutucd = pZrnsyujyutucd;
    }

    private String zrnsyujyutumeicd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYUJYUTUMEICD)
    public String getZrnsyujyutumeicd() {
        return zrnsyujyutumeicd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyujyutumeicd(String pZrnsyujyutumeicd) {
        zrnsyujyutumeicd = pZrnsyujyutumeicd;
    }

    private String zrntuuinkangogeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTUUINKANGOGENINKBN)
    public String getZrntuuinkangogeninkbn() {
        return zrntuuinkangogeninkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuuinkangogeninkbn(String pZrntuuinkangogeninkbn) {
        zrntuuinkangogeninkbn = pZrntuuinkangogeninkbn;
    }

    private String zrnundoukisonsyoukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNUNDOUKISONSYOUKBN)
    public String getZrnundoukisonsyoukbn() {
        return zrnundoukisonsyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnundoukisonsyoukbn(String pZrnundoukisonsyoukbn) {
        zrnundoukisonsyoukbn = pZrnundoukisonsyoukbn;
    }

    private String zrnganmensonsyoukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGANMENSONSYOUKBN)
    public String getZrnganmensonsyoukbn() {
        return zrnganmensonsyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnganmensonsyoukbn(String pZrnganmensonsyoukbn) {
        zrnganmensonsyoukbn = pZrnganmensonsyoukbn;
    }

    private String zrnsonsyougeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSONSYOUGENINKBN)
    public String getZrnsonsyougeninkbn() {
        return zrnsonsyougeninkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsonsyougeninkbn(String pZrnsonsyougeninkbn) {
        zrnsonsyougeninkbn = pZrnsonsyougeninkbn;
    }

    private String zrnkikensportskbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKIKENSPORTSKBN)
    public String getZrnkikensportskbn() {
        return zrnkikensportskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkikensportskbn(String pZrnkikensportskbn) {
        zrnkikensportskbn = pZrnkikensportskbn;
    }

    private String zrnyobiv2x2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV2X2)
    public String getZrnyobiv2x2() {
        return zrnyobiv2x2;
    }

    public void setZrnyobiv2x2(String pZrnyobiv2x2) {
        zrnyobiv2x2 = pZrnyobiv2x2;
    }

    private String zrnsiharainissuukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSIHARAINISSUUKBN)
    public String getZrnsiharainissuukbn() {
        return zrnsiharainissuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiharainissuukbn(String pZrnsiharainissuukbn) {
        zrnsiharainissuukbn = pZrnsiharainissuukbn;
    }

    private String zrnkakuseikatakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKAKUSEIKATAKBN)
    public String getZrnkakuseikatakbn() {
        return zrnkakuseikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuseikatakbn(String pZrnkakuseikatakbn) {
        zrnkakuseikatakbn = pZrnkakuseikatakbn;
    }

    private String zrnbosyuukeirokbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNBOSYUUKEIROKBN)
    public String getZrnbosyuukeirokbn() {
        return zrnbosyuukeirokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbosyuukeirokbn(String pZrnbosyuukeirokbn) {
        zrnbosyuukeirokbn = pZrnbosyuukeirokbn;
    }

    private String zrnpmenhutanpohyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNPMENHUTANPOHYJ)
    public String getZrnpmenhutanpohyj() {
        return zrnpmenhutanpohyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmenhutanpohyj(String pZrnpmenhutanpohyj) {
        zrnpmenhutanpohyj = pZrnpmenhutanpohyj;
    }

    private String zrnkousinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKOUSINKBN)
    public String getZrnkousinkbn() {
        return zrnkousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousinkbn(String pZrnkousinkbn) {
        zrnkousinkbn = pZrnkousinkbn;
    }

    private String zrnkusnmetkyksykipjyutuym;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKUSNMETKYKSYKIPJYUTUYM)
    public String getZrnkusnmetkyksykipjyutuym() {
        return zrnkusnmetkyksykipjyutuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnkusnmetkyksykipjyutuym(String pZrnkusnmetkyksykipjyutuym) {
        zrnkusnmetkyksykipjyutuym = pZrnkusnmetkyksykipjyutuym;
    }

    private String zrntoukeiyousinsakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOUKEIYOUSINSAKBN)
    public String getZrntoukeiyousinsakbn() {
        return zrntoukeiyousinsakbn;
    }

    public void setZrntoukeiyousinsakbn(String pZrntoukeiyousinsakbn) {
        zrntoukeiyousinsakbn = pZrntoukeiyousinsakbn;
    }

    private String zrnpmenhukakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNPMENHUKAKBN)
    public String getZrnpmenhukakbn() {
        return zrnpmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmenhukakbn(String pZrnpmenhukakbn) {
        zrnpmenhukakbn = pZrnpmenhukakbn;
    }

    private String zrnpmenkbnv2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNPMENKBNV2)
    public String getZrnpmenkbnv2() {
        return zrnpmenkbnv2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenkbnv2(String pZrnpmenkbnv2) {
        zrnpmenkbnv2 = pZrnpmenkbnv2;
    }

    private String zrnketteikijyunkanwakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKETTEIKIJYUNKANWAKBN)
    public String getZrnketteikijyunkanwakbn() {
        return zrnketteikijyunkanwakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnketteikijyunkanwakbn(String pZrnketteikijyunkanwakbn) {
        zrnketteikijyunkanwakbn = pZrnketteikijyunkanwakbn;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrntokuyakukigousedaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUYAKUKIGOUSEDAIKBN)
    public String getZrntokuyakukigousedaikbn() {
        return zrntokuyakukigousedaikbn;
    }

    public void setZrntokuyakukigousedaikbn(String pZrntokuyakukigousedaikbn) {
        zrntokuyakukigousedaikbn = pZrntokuyakukigousedaikbn;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnstdssnskbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSTDSSNSKBN)
    public String getZrnstdssnskbn() {
        return zrnstdssnskbn;
    }

    public void setZrnstdssnskbn(String pZrnstdssnskbn) {
        zrnstdssnskbn = pZrnstdssnskbn;
    }

    private String zrnsotodasikousinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSOTODASIKOUSINKBN)
    public String getZrnsotodasikousinkbn() {
        return zrnsotodasikousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasikousinkbn(String pZrnsotodasikousinkbn) {
        zrnsotodasikousinkbn = pZrnsotodasikousinkbn;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private String zrnqpackhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNQPACKHYJ)
    public String getZrnqpackhyj() {
        return zrnqpackhyj;
    }

    public void setZrnqpackhyj(String pZrnqpackhyj) {
        zrnqpackhyj = pZrnqpackhyj;
    }

    private String zrnbunkatukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNBUNKATUKBN)
    public String getZrnbunkatukbn() {
        return zrnbunkatukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbunkatukbn(String pZrnbunkatukbn) {
        zrnbunkatukbn = pZrnbunkatukbn;
    }

    private String zrntenkanhosyouminaosikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTENKANHOSYOUMINAOSIKBN)
    public String getZrntenkanhosyouminaosikbn() {
        return zrntenkanhosyouminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanhosyouminaosikbn(String pZrntenkanhosyouminaosikbn) {
        zrntenkanhosyouminaosikbn = pZrntenkanhosyouminaosikbn;
    }

    private String zrnkousinmaesiharaihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKOUSINMAESIHARAIHYJ)
    public String getZrnkousinmaesiharaihyj() {
        return zrnkousinmaesiharaihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousinmaesiharaihyj(String pZrnkousinmaesiharaihyj) {
        zrnkousinmaesiharaihyj = pZrnkousinmaesiharaihyj;
    }

    private String zrndouitunyuuinno;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNDOUITUNYUUINNO)
    public String getZrndouitunyuuinno() {
        return zrndouitunyuuinno;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrndouitunyuuinno(String pZrndouitunyuuinno) {
        zrndouitunyuuinno = pZrndouitunyuuinno;
    }

    private String zrnsyujyutujinyuuinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYUJYUTUJINYUUINKBN)
    public String getZrnsyujyutujinyuuinkbn() {
        return zrnsyujyutujinyuuinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyujyutujinyuuinkbn(String pZrnsyujyutujinyuuinkbn) {
        zrnsyujyutujinyuuinkbn = pZrnsyujyutujinyuuinkbn;
    }

    private String zrnsyujyutusyuruikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYUJYUTUSYURUIKBN)
    public String getZrnsyujyutusyuruikbn() {
        return zrnsyujyutusyuruikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyujyutusyuruikbn(String pZrnsyujyutusyuruikbn) {
        zrnsyujyutusyuruikbn = pZrnsyujyutusyuruikbn;
    }

    private String zrngannyuuinkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGANNYUUINKBN)
    public String getZrngannyuuinkbn() {
        return zrngannyuuinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngannyuuinkbn(String pZrngannyuuinkbn) {
        zrngannyuuinkbn = pZrngannyuuinkbn;
    }

    private String zrnhokenhoutekiyouhyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNHOKENHOUTEKIYOUHYOUJI)
    public String getZrnhokenhoutekiyouhyouji() {
        return zrnhokenhoutekiyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhokenhoutekiyouhyouji(String pZrnhokenhoutekiyouhyouji) {
        zrnhokenhoutekiyouhyouji = pZrnhokenhoutekiyouhyouji;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private String zrntokuteijyoutaihushrhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZrntokuteijyoutaihushrhyj() {
        return zrntokuteijyoutaihushrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteijyoutaihushrhyj(String pZrntokuteijyoutaihushrhyj) {
        zrntokuteijyoutaihushrhyj = pZrntokuteijyoutaihushrhyj;
    }

    private String zrnsisyacd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSISYACD)
    public String getZrnsisyacd() {
        return zrnsisyacd;
    }

    public void setZrnsisyacd(String pZrnsisyacd) {
        zrnsisyacd = pZrnsisyacd;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrnsuuriyouyobiv11;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSUURIYOUYOBIV11)
    public String getZrnsuuriyouyobiv11() {
        return zrnsuuriyouyobiv11;
    }

    public void setZrnsuuriyouyobiv11(String pZrnsuuriyouyobiv11) {
        zrnsuuriyouyobiv11 = pZrnsuuriyouyobiv11;
    }

    private String zrnyoukaigojyoutaikaisiymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOUKAIGOJYOUTAIKAISIYMD)
    public String getZrnyoukaigojyoutaikaisiymd() {
        return zrnyoukaigojyoutaikaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyoukaigojyoutaikaisiymd(String pZrnyoukaigojyoutaikaisiymd) {
        zrnyoukaigojyoutaikaisiymd = pZrnyoukaigojyoutaikaisiymd;
    }

    private String zrnyoukaigojyoutaiendymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOUKAIGOJYOUTAIENDYMD)
    public String getZrnyoukaigojyoutaiendymd() {
        return zrnyoukaigojyoutaiendymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyoukaigojyoutaiendymd(String pZrnyoukaigojyoutaiendymd) {
        zrnyoukaigojyoutaiendymd = pZrnyoukaigojyoutaiendymd;
    }

    private String zrnrendouyousntkjyubbnhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNRENDOUYOUSNTKJYUBBNHYJ)
    public String getZrnrendouyousntkjyubbnhyj() {
        return zrnrendouyousntkjyubbnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrendouyousntkjyubbnhyj(String pZrnrendouyousntkjyubbnhyj) {
        zrnrendouyousntkjyubbnhyj = pZrnrendouyousntkjyubbnhyj;
    }

    private String zrnmusentakukeiyakukbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNMUSENTAKUKEIYAKUKBN)
    public String getZrnmusentakukeiyakukbn() {
        return zrnmusentakukeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmusentakukeiyakukbn(String pZrnmusentakukeiyakukbn) {
        zrnmusentakukeiyakukbn = pZrnmusentakukeiyakukbn;
    }

    private String zrnmaruteiskeijihukahyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNMARUTEISKEIJIHUKAHYJ)
    public String getZrnmaruteiskeijihukahyj() {
        return zrnmaruteiskeijihukahyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteiskeijihukahyj(String pZrnmaruteiskeijihukahyj) {
        zrnmaruteiskeijihukahyj = pZrnmaruteiskeijihukahyj;
    }

    private String zrntoliplhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOLIPLHYJ)
    public String getZrntoliplhyj() {
        return zrntoliplhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntoliplhyj(String pZrntoliplhyj) {
        zrntoliplhyj = pZrntoliplhyj;
    }

    private String zrnstdssytikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSTDSSYTIKBN)
    public String getZrnstdssytikbn() {
        return zrnstdssytikbn;
    }

    public void setZrnstdssytikbn(String pZrnstdssytikbn) {
        zrnstdssytikbn = pZrnstdssytikbn;
    }

    private String zrnhisei;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNHISEI)
    public String getZrnhisei() {
        return zrnhisei;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhisei(String pZrnhisei) {
        zrnhisei = pZrnhisei;
    }

    private Integer zrnsuuriyobin9;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSUURIYOBIN9)
    public Integer getZrnsuuriyobin9() {
        return zrnsuuriyobin9;
    }

    public void setZrnsuuriyobin9(Integer pZrnsuuriyobin9) {
        zrnsuuriyobin9 = pZrnsuuriyobin9;
    }

    private Long zrnsaigaisibousiharaikngk;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSAIGAISIBOUSIHARAIKNGK)
    public Long getZrnsaigaisibousiharaikngk() {
        return zrnsaigaisibousiharaikngk;
    }

    public void setZrnsaigaisibousiharaikngk(Long pZrnsaigaisibousiharaikngk) {
        zrnsaigaisibousiharaikngk = pZrnsaigaisibousiharaikngk;
    }

    private String zrntokuyakuhinen;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUYAKUHINEN)
    public String getZrntokuyakuhinen() {
        return zrntokuyakuhinen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokuyakuhinen(String pZrntokuyakuhinen) {
        zrntokuyakuhinen = pZrntokuyakuhinen;
    }

    private Integer zrngnykbttryukyuhkntusnkisu;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGNYKBTTRYUKYUHKNTUSNKISU)
    public Integer getZrngnykbttryukyuhkntusnkisu() {
        return zrngnykbttryukyuhkntusnkisu;
    }

    public void setZrngnykbttryukyuhkntusnkisu(Integer pZrngnykbttryukyuhkntusnkisu) {
        zrngnykbttryukyuhkntusnkisu = pZrngnykbttryukyuhkntusnkisu;
    }

    private String zrngansyuruikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGANSYURUIKBN)
    public String getZrngansyuruikbn() {
        return zrngansyuruikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansyuruikbn(String pZrngansyuruikbn) {
        zrngansyuruikbn = pZrngansyuruikbn;
    }

    private String zrnganyakubutusyuruikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGANYAKUBUTUSYURUIKBN)
    public String getZrnganyakubutusyuruikbn() {
        return zrnganyakubutusyuruikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnganyakubutusyuruikbn(String pZrnganyakubutusyuruikbn) {
        zrnganyakubutusyuruikbn = pZrnganyakubutusyuruikbn;
    }

    private String zrnsyuuroukigjyujtjyutikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYUUROUKIGJYUJTJYUTIKBN)
    public String getZrnsyuuroukigjyujtjyutikbn() {
        return zrnsyuuroukigjyujtjyutikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuuroukigjyujtjyutikbn(String pZrnsyuuroukigjyujtjyutikbn) {
        zrnsyuuroukigjyujtjyutikbn = pZrnsyuuroukigjyujtjyutikbn;
    }

    private String zrnsyuuroukigjyujtgeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYUUROUKIGJYUJTGENINKBN)
    public String getZrnsyuuroukigjyujtgeninkbn() {
        return zrnsyuuroukigjyujtgeninkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuuroukigjyujtgeninkbn(String pZrnsyuuroukigjyujtgeninkbn) {
        zrnsyuuroukigjyujtgeninkbn = pZrnsyuuroukigjyujtgeninkbn;
    }

    private String zrnkigjyujtjyoutaigeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKIGJYUJTJYOUTAIGENINKBN)
    public String getZrnkigjyujtjyoutaigeninkbn() {
        return zrnkigjyujtjyoutaigeninkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigjyujtjyoutaigeninkbn(String pZrnkigjyujtjyoutaigeninkbn) {
        zrnkigjyujtjyoutaigeninkbn = pZrnkigjyujtjyoutaigeninkbn;
    }

    private String zrnsykmtssyukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYKMTSSYUKAHIKBN)
    public String getZrnsykmtssyukahikbn() {
        return zrnsykmtssyukahikbn;
    }

    public void setZrnsykmtssyukahikbn(String pZrnsykmtssyukahikbn) {
        zrnsykmtssyukahikbn = pZrnsykmtssyukahikbn;
    }

    private String zrnfktrsmtkahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNFKTRSMTKAHIKBN)
    public String getZrnfktrsmtkahikbn() {
        return zrnfktrsmtkahikbn;
    }

    public void setZrnfktrsmtkahikbn(String pZrnfktrsmtkahikbn) {
        zrnfktrsmtkahikbn = pZrnfktrsmtkahikbn;
    }

    private String zrnhokoukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNHOKOUKAHIKBN)
    public String getZrnhokoukahikbn() {
        return zrnhokoukahikbn;
    }

    public void setZrnhokoukahikbn(String pZrnhokoukahikbn) {
        zrnhokoukahikbn = pZrnhokoukahikbn;
    }

    private String zrnnyykkahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNNYYKKAHIKBN)
    public String getZrnnyykkahikbn() {
        return zrnnyykkahikbn;
    }

    public void setZrnnyykkahikbn(String pZrnnyykkahikbn) {
        zrnnyykkahikbn = pZrnnyykkahikbn;
    }

    private String zrnihukutyakudatukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNIHUKUTYAKUDATUKAHIKBN)
    public String getZrnihukutyakudatukahikbn() {
        return zrnihukutyakudatukahikbn;
    }

    public void setZrnihukutyakudatukahikbn(String pZrnihukutyakudatukahikbn) {
        zrnihukutyakudatukahikbn = pZrnihukutyakudatukahikbn;
    }

    private String zrnngerkahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNNGERKAHIKBN)
    public String getZrnngerkahikbn() {
        return zrnngerkahikbn;
    }

    public void setZrnngerkahikbn(String pZrnngerkahikbn) {
        zrnngerkahikbn = pZrnngerkahikbn;
    }

    private String zrnseiketuseiyoukahikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSEIKETUSEIYOUKAHIKBN)
    public String getZrnseiketuseiyoukahikbn() {
        return zrnseiketuseiyoukahikbn;
    }

    public void setZrnseiketuseiyoukahikbn(String pZrnseiketuseiyoukahikbn) {
        zrnseiketuseiyoukahikbn = pZrnseiketuseiyoukahikbn;
    }

    private String zrnnintisyougeninkbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNNINTISYOUGENINKBN)
    public String getZrnnintisyougeninkbn() {
        return zrnnintisyougeninkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnintisyougeninkbn(String pZrnnintisyougeninkbn) {
        zrnnintisyougeninkbn = pZrnnintisyougeninkbn;
    }

    private String zrnsyuruhnujyujtjyutikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSYURUHNUJYUJTJYUTIKBN)
    public String getZrnsyuruhnujyujtjyutikbn() {
        return zrnsyuruhnujyujtjyutikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuruhnujyujtjyutikbn(String pZrnsyuruhnujyujtjyutikbn) {
        zrnsyuruhnujyujtjyutikbn = pZrnsyuruhnujyujtjyutikbn;
    }

    private String zrntokuteisyougaikbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNTOKUTEISYOUGAIKBN)
    public String getZrntokuteisyougaikbn() {
        return zrntokuteisyougaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteisyougaikbn(String pZrntokuteisyougaikbn) {
        zrntokuteisyougaikbn = pZrntokuteisyougaikbn;
    }

    private String zrndatakanrino2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNDATAKANRINO2)
    public String getZrndatakanrino2() {
        return zrndatakanrino2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino2(String pZrndatakanrino2) {
        zrndatakanrino2 = pZrndatakanrino2;
    }

    private String zrndatakanrino3;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNDATAKANRINO3)
    public String getZrndatakanrino3() {
        return zrndatakanrino3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino3(String pZrndatakanrino3) {
        zrndatakanrino3 = pZrndatakanrino3;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnbluekeizokuhyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNBLUEKEIZOKUHYOUJI)
    public String getZrnbluekeizokuhyouji() {
        return zrnbluekeizokuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbluekeizokuhyouji(String pZrnbluekeizokuhyouji) {
        zrnbluekeizokuhyouji = pZrnbluekeizokuhyouji;
    }

    private String zrnzyrthntiyustatuskbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNZYRTHNTIYUSTATUSKBN)
    public String getZrnzyrthntiyustatuskbn() {
        return zrnzyrthntiyustatuskbn;
    }

    public void setZrnzyrthntiyustatuskbn(String pZrnzyrthntiyustatuskbn) {
        zrnzyrthntiyustatuskbn = pZrnzyrthntiyustatuskbn;
    }

    private String zrnzyrthntiyustatuskbnx2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNZYRTHNTIYUSTATUSKBNX2)
    public String getZrnzyrthntiyustatuskbnx2() {
        return zrnzyrthntiyustatuskbnx2;
    }

    public void setZrnzyrthntiyustatuskbnx2(String pZrnzyrthntiyustatuskbnx2) {
        zrnzyrthntiyustatuskbnx2 = pZrnzyrthntiyustatuskbnx2;
    }

    private String zrnzyrthntiyustatuskbnx3;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNZYRTHNTIYUSTATUSKBNX3)
    public String getZrnzyrthntiyustatuskbnx3() {
        return zrnzyrthntiyustatuskbnx3;
    }

    public void setZrnzyrthntiyustatuskbnx3(String pZrnzyrthntiyustatuskbnx3) {
        zrnzyrthntiyustatuskbnx3 = pZrnzyrthntiyustatuskbnx3;
    }

    private String zrnzyrthntiyustatuskbnx4;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNZYRTHNTIYUSTATUSKBNX4)
    public String getZrnzyrthntiyustatuskbnx4() {
        return zrnzyrthntiyustatuskbnx4;
    }

    public void setZrnzyrthntiyustatuskbnx4(String pZrnzyrthntiyustatuskbnx4) {
        zrnzyrthntiyustatuskbnx4 = pZrnzyrthntiyustatuskbnx4;
    }

    private String zrnzyrthntiyustatuskbnx5;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNZYRTHNTIYUSTATUSKBNX5)
    public String getZrnzyrthntiyustatuskbnx5() {
        return zrnzyrthntiyustatuskbnx5;
    }

    public void setZrnzyrthntiyustatuskbnx5(String pZrnzyrthntiyustatuskbnx5) {
        zrnzyrthntiyustatuskbnx5 = pZrnzyrthntiyustatuskbnx5;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnknkuzusnzyrtx2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKNKUZUSNZYRTX2)
    public String getZrnknkuzusnzyrtx2() {
        return zrnknkuzusnzyrtx2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrtx2(String pZrnknkuzusnzyrtx2) {
        zrnknkuzusnzyrtx2 = pZrnknkuzusnzyrtx2;
    }

    private String zrnsinkeiyakujivithkhyouji;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSINKEIYAKUJIVITHKHYOUJI)
    public String getZrnsinkeiyakujivithkhyouji() {
        return zrnsinkeiyakujivithkhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinkeiyakujivithkhyouji(String pZrnsinkeiyakujivithkhyouji) {
        zrnsinkeiyakujivithkhyouji = pZrnsinkeiyakujivithkhyouji;
    }

    private String zrnpwrbksidhitekiyouhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNPWRBKSIDHITEKIYOUHYJ)
    public String getZrnpwrbksidhitekiyouhyj() {
        return zrnpwrbksidhitekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpwrbksidhitekiyouhyj(String pZrnpwrbksidhitekiyouhyj) {
        zrnpwrbksidhitekiyouhyj = pZrnpwrbksidhitekiyouhyj;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnsuuriyouyobin4;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSUURIYOUYOBIN4)
    public String getZrnsuuriyouyobin4() {
        return zrnsuuriyouyobin4;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsuuriyouyobin4(String pZrnsuuriyouyobin4) {
        zrnsuuriyouyobin4 = pZrnsuuriyouyobin4;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private Long zrngaikadatesiharais;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGAIKADATESIHARAIS)
    public Long getZrngaikadatesiharais() {
        return zrngaikadatesiharais;
    }

    public void setZrngaikadatesiharais(Long pZrngaikadatesiharais) {
        zrngaikadatesiharais = pZrngaikadatesiharais;
    }

    private Long zrngaikadatesyukeiyakus;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGAIKADATESYUKEIYAKUS)
    public Long getZrngaikadatesyukeiyakus() {
        return zrngaikadatesyukeiyakus;
    }

    public void setZrngaikadatesyukeiyakus(Long pZrngaikadatesyukeiyakus) {
        zrngaikadatesyukeiyakus = pZrngaikadatesyukeiyakus;
    }

    private Long zrngaikadatesyukeiyakup;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNGAIKADATESYUKEIYAKUP)
    public Long getZrngaikadatesyukeiyakup() {
        return zrngaikadatesyukeiyakup;
    }

    public void setZrngaikadatesyukeiyakup(Long pZrngaikadatesyukeiyakup) {
        zrngaikadatesyukeiyakup = pZrngaikadatesyukeiyakup;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private String zrnsuuriyouyobin10;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNSUURIYOUYOBIN10)
    public String getZrnsuuriyouyobin10() {
        return zrnsuuriyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10(String pZrnsuuriyouyobin10) {
        zrnsuuriyouyobin10 = pZrnsuuriyouyobin10;
    }

    private String zrnyobiv10x2;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV10X2)
    public String getZrnyobiv10x2() {
        return zrnyobiv10x2;
    }

    public void setZrnyobiv10x2(String pZrnyobiv10x2) {
        zrnyobiv10x2 = pZrnyobiv10x2;
    }

    private Long zrnmvatyouseigow;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNMVATYOUSEIGOW)
    public Long getZrnmvatyouseigow() {
        return zrnmvatyouseigow;
    }

    public void setZrnmvatyouseigow(Long pZrnmvatyouseigow) {
        zrnmvatyouseigow = pZrnmvatyouseigow;
    }

    private Long zrnmvakeisanjisknnjynbkn;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNMVAKEISANJISKNNJYNBKN)
    public Long getZrnmvakeisanjisknnjynbkn() {
        return zrnmvakeisanjisknnjynbkn;
    }

    public void setZrnmvakeisanjisknnjynbkn(Long pZrnmvakeisanjisknnjynbkn) {
        zrnmvakeisanjisknnjynbkn = pZrnmvakeisanjisknnjynbkn;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_KyhknShrJyoukyouRnrkRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }
}