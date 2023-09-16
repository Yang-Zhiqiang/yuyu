package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.id.PKZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.GenQZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiTy;

/**
 * 口座振替未入通知テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KouzahuriMinyuTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriMinyuTuutiTy}</td><td colspan="3">口座振替未入通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_KouzahuriMinyuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KouzahuriMinyuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10 ztyansyuyouyobin10}</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkj ztyshsnmkj}</td><td>（中継用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv43 ztyyobiv43}</td><td>（中継用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x2 ztyansyuyouyobin10x2}</td><td>（中継用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawsosikikj ztytawsosikikj}</td><td>（中継用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj ztytawadr1kj}</td><td>（中継用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj ztytawadr2kj}</td><td>（中継用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr3kj ztytawadr3kj}</td><td>（中継用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelnov14 ztytawtelnov14}</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou1 ztytawteluktkkanou1}</td><td>（中継用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou2 ztytawteluktkkanou2}</td><td>（中継用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawsosikinmkj ztydai2tawsosikinmkj}</td><td>（中継用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawtelno ztydai2tawtelno}</td><td>（中継用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclatosyono ztysclatosyono}</td><td>（中継用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakunm15keta ztysakunm15keta}</td><td>（中継用）作成番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv61 ztyyobiv61}</td><td>（中継用）予備項目Ｖ６１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutinm30keta ztytuutinm30keta}</td><td>（中継用）通知名称（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg1 ztyminyuttmsg1}</td><td>（中継用）未入通知メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg2 ztyminyuttmsg2}</td><td>（中継用）未入通知メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg3 ztyminyuttmsg3}</td><td>（中継用）未入通知メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg4 ztyminyuttmsg4}</td><td>（中継用）未入通知メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg5 ztyminyuttmsg5}</td><td>（中継用）未入通知メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg6 ztyminyuttmsg6}</td><td>（中継用）未入通知メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg7 ztyminyuttmsg7}</td><td>（中継用）未入通知メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg8 ztyminyuttmsg8}</td><td>（中継用）未入通知メッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg9 ztyminyuttmsg9}</td><td>（中継用）未入通知メッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg10 ztyminyuttmsg10}</td><td>（中継用）未入通知メッセージ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg11 ztyminyuttmsg11}</td><td>（中継用）未入通知メッセージ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttmsg12 ztyminyuttmsg12}</td><td>（中継用）未入通知メッセージ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv174 ztyyobiv174}</td><td>（中継用）予備項目Ｖ１７４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypannainm ztypannainm}</td><td>（中継用）保険料案内名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhou12keta ztyhrkhou12keta}</td><td>（中継用）払込方法（１２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynextkzhrnaiyou1 ztynextkzhrnaiyou1}</td><td>（中継用）次回振替内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynextkzhrnaiyou2 ztynextkzhrnaiyou2}</td><td>（中継用）次回振替内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynextkzhrnaiyou3 ztynextkzhrnaiyou3}</td><td>（中継用）次回振替内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaikokuyykk1 ztysaikokuyykk1}</td><td>（中継用）催告月猶予期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaikokuyykk2 ztysaikokuyykk2}</td><td>（中継用）催告月猶予期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkmiraimsg1 ztyhrkmiraimsg1}</td><td>（中継用）振込依頼メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkmiraimsg2 ztyhrkmiraimsg2}</td><td>（中継用）振込依頼メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkmiraimsg3 ztyhrkmiraimsg3}</td><td>（中継用）振込依頼メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenhurinaiyou1 ztyzenhurinaiyou1}</td><td>（中継用）前回振替内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenhurinaiyou2 ztyzenhurinaiyou2}</td><td>（中継用）前回振替内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenhurinaiyou3 ztyzenhurinaiyou3}</td><td>（中継用）前回振替内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenhurinaiyou4 ztyzenhurinaiyou4}</td><td>（中継用）前回振替内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv196 ztyyobiv196}</td><td>（中継用）予備項目Ｖ１９６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz37keta1 ztyhurikaekz37keta1}</td><td>（中継用）振替口座（３７桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz37keta2 ztyhurikaekz37keta2}</td><td>（中継用）振替口座（３７桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz37keta3 ztyhurikaekz37keta3}</td><td>（中継用）振替口座（３７桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz37keta4 ztyhurikaekz37keta4}</td><td>（中継用）振替口座（３７桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz37keta5 ztyhurikaekz37keta5}</td><td>（中継用）振替口座（３７桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz37keta6 ztyhurikaekz37keta6}</td><td>（中継用）振替口座（３７桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv88 ztyyobiv88}</td><td>（中継用）予備項目Ｖ８８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x6 ztyansyuyouyobin10x6}</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg1 ztyminyuttaddmsg1}</td><td>（中継用）未入通知追加メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg2 ztyminyuttaddmsg2}</td><td>（中継用）未入通知追加メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg3 ztyminyuttaddmsg3}</td><td>（中継用）未入通知追加メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg4 ztyminyuttaddmsg4}</td><td>（中継用）未入通知追加メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg5 ztyminyuttaddmsg5}</td><td>（中継用）未入通知追加メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg6 ztyminyuttaddmsg6}</td><td>（中継用）未入通知追加メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg7 ztyminyuttaddmsg7}</td><td>（中継用）未入通知追加メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg8 ztyminyuttaddmsg8}</td><td>（中継用）未入通知追加メッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg9 ztyminyuttaddmsg9}</td><td>（中継用）未入通知追加メッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg10 ztyminyuttaddmsg10}</td><td>（中継用）未入通知追加メッセージ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg11 ztyminyuttaddmsg11}</td><td>（中継用）未入通知追加メッセージ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg12 ztyminyuttaddmsg12}</td><td>（中継用）未入通知追加メッセージ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg13 ztyminyuttaddmsg13}</td><td>（中継用）未入通知追加メッセージ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg14 ztyminyuttaddmsg14}</td><td>（中継用）未入通知追加メッセージ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg15 ztyminyuttaddmsg15}</td><td>（中継用）未入通知追加メッセージ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg16 ztyminyuttaddmsg16}</td><td>（中継用）未入通知追加メッセージ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg17 ztyminyuttaddmsg17}</td><td>（中継用）未入通知追加メッセージ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg18 ztyminyuttaddmsg18}</td><td>（中継用）未入通知追加メッセージ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg19 ztyminyuttaddmsg19}</td><td>（中継用）未入通知追加メッセージ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg20 ztyminyuttaddmsg20}</td><td>（中継用）未入通知追加メッセージ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuttaddmsg21 ztyminyuttaddmsg21}</td><td>（中継用）未入通知追加メッセージ２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250 ztyyobiv250}</td><td>（中継用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv60 ztyyobiv60}</td><td>（中継用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x7 ztyansyuyouyobin10x7}</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriMinyuTuutiTy
 * @see     PKZT_KouzahuriMinyuTuutiTy
 * @see     QZT_KouzahuriMinyuTuutiTy
 * @see     GenQZT_KouzahuriMinyuTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_KouzahuriMinyuTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_KouzahuriMinyuTuutiTy.class)
public abstract class GenZT_KouzahuriMinyuTuutiTy extends AbstractExDBEntity<ZT_KouzahuriMinyuTuutiTy, PKZT_KouzahuriMinyuTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KouzahuriMinyuTuutiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDKJ         = "ztytyouhyouymdkj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYANSYUYOUYOBIN10       = "ztyansyuyouyobin10";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJ               = "ztyshsnmkj";
    public static final String ZTYYOBIV43               = "ztyyobiv43";
    public static final String ZTYANSYUYOUYOBIN10X2     = "ztyansyuyouyobin10x2";
    public static final String ZTYTAWSOSIKIKJ           = "ztytawsosikikj";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ             = "ztytawadr1kj";
    public static final String ZTYTAWADR2KJ             = "ztytawadr2kj";
    public static final String ZTYTAWADR3KJ             = "ztytawadr3kj";
    public static final String ZTYTAWTELNOV14           = "ztytawtelnov14";
    public static final String ZTYTAWTELUKTKKANOU1      = "ztytawteluktkkanou1";
    public static final String ZTYTAWTELUKTKKANOU2      = "ztytawteluktkkanou2";
    public static final String ZTYDAI2TAWSOSIKINMKJ     = "ztydai2tawsosikinmkj";
    public static final String ZTYDAI2TAWTELNO          = "ztydai2tawtelno";
    public static final String ZTYSCLATOSYONO           = "ztysclatosyono";
    public static final String ZTYSAKUNM15KETA          = "ztysakunm15keta";
    public static final String ZTYYOBIV61               = "ztyyobiv61";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYTUUTINM30KETA         = "ztytuutinm30keta";
    public static final String ZTYMINYUTTMSG1           = "ztyminyuttmsg1";
    public static final String ZTYMINYUTTMSG2           = "ztyminyuttmsg2";
    public static final String ZTYMINYUTTMSG3           = "ztyminyuttmsg3";
    public static final String ZTYMINYUTTMSG4           = "ztyminyuttmsg4";
    public static final String ZTYMINYUTTMSG5           = "ztyminyuttmsg5";
    public static final String ZTYMINYUTTMSG6           = "ztyminyuttmsg6";
    public static final String ZTYMINYUTTMSG7           = "ztyminyuttmsg7";
    public static final String ZTYMINYUTTMSG8           = "ztyminyuttmsg8";
    public static final String ZTYMINYUTTMSG9           = "ztyminyuttmsg9";
    public static final String ZTYMINYUTTMSG10          = "ztyminyuttmsg10";
    public static final String ZTYMINYUTTMSG11          = "ztyminyuttmsg11";
    public static final String ZTYMINYUTTMSG12          = "ztyminyuttmsg12";
    public static final String ZTYYOBIV174              = "ztyyobiv174";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYPANNAINM              = "ztypannainm";
    public static final String ZTYHRKHOU12KETA          = "ztyhrkhou12keta";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYNEXTKZHRNAIYOU1       = "ztynextkzhrnaiyou1";
    public static final String ZTYNEXTKZHRNAIYOU2       = "ztynextkzhrnaiyou2";
    public static final String ZTYNEXTKZHRNAIYOU3       = "ztynextkzhrnaiyou3";
    public static final String ZTYSAIKOKUYYKK1          = "ztysaikokuyykk1";
    public static final String ZTYSAIKOKUYYKK2          = "ztysaikokuyykk2";
    public static final String ZTYHRKMIRAIMSG1          = "ztyhrkmiraimsg1";
    public static final String ZTYHRKMIRAIMSG2          = "ztyhrkmiraimsg2";
    public static final String ZTYHRKMIRAIMSG3          = "ztyhrkmiraimsg3";
    public static final String ZTYZENHURINAIYOU1        = "ztyzenhurinaiyou1";
    public static final String ZTYZENHURINAIYOU2        = "ztyzenhurinaiyou2";
    public static final String ZTYZENHURINAIYOU3        = "ztyzenhurinaiyou3";
    public static final String ZTYZENHURINAIYOU4        = "ztyzenhurinaiyou4";
    public static final String ZTYYOBIV196              = "ztyyobiv196";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";
    public static final String ZTYHURIKAEKZ37KETA1      = "ztyhurikaekz37keta1";
    public static final String ZTYHURIKAEKZ37KETA2      = "ztyhurikaekz37keta2";
    public static final String ZTYHURIKAEKZ37KETA3      = "ztyhurikaekz37keta3";
    public static final String ZTYHURIKAEKZ37KETA4      = "ztyhurikaekz37keta4";
    public static final String ZTYHURIKAEKZ37KETA5      = "ztyhurikaekz37keta5";
    public static final String ZTYHURIKAEKZ37KETA6      = "ztyhurikaekz37keta6";
    public static final String ZTYYOBIV88               = "ztyyobiv88";
    public static final String ZTYANSYUYOUYOBIN10X6     = "ztyansyuyouyobin10x6";
    public static final String ZTYMINYUTTADDMSG1        = "ztyminyuttaddmsg1";
    public static final String ZTYMINYUTTADDMSG2        = "ztyminyuttaddmsg2";
    public static final String ZTYMINYUTTADDMSG3        = "ztyminyuttaddmsg3";
    public static final String ZTYMINYUTTADDMSG4        = "ztyminyuttaddmsg4";
    public static final String ZTYMINYUTTADDMSG5        = "ztyminyuttaddmsg5";
    public static final String ZTYMINYUTTADDMSG6        = "ztyminyuttaddmsg6";
    public static final String ZTYMINYUTTADDMSG7        = "ztyminyuttaddmsg7";
    public static final String ZTYMINYUTTADDMSG8        = "ztyminyuttaddmsg8";
    public static final String ZTYMINYUTTADDMSG9        = "ztyminyuttaddmsg9";
    public static final String ZTYMINYUTTADDMSG10       = "ztyminyuttaddmsg10";
    public static final String ZTYMINYUTTADDMSG11       = "ztyminyuttaddmsg11";
    public static final String ZTYMINYUTTADDMSG12       = "ztyminyuttaddmsg12";
    public static final String ZTYMINYUTTADDMSG13       = "ztyminyuttaddmsg13";
    public static final String ZTYMINYUTTADDMSG14       = "ztyminyuttaddmsg14";
    public static final String ZTYMINYUTTADDMSG15       = "ztyminyuttaddmsg15";
    public static final String ZTYMINYUTTADDMSG16       = "ztyminyuttaddmsg16";
    public static final String ZTYMINYUTTADDMSG17       = "ztyminyuttaddmsg17";
    public static final String ZTYMINYUTTADDMSG18       = "ztyminyuttaddmsg18";
    public static final String ZTYMINYUTTADDMSG19       = "ztyminyuttaddmsg19";
    public static final String ZTYMINYUTTADDMSG20       = "ztyminyuttaddmsg20";
    public static final String ZTYMINYUTTADDMSG21       = "ztyminyuttaddmsg21";
    public static final String ZTYYOBIV250              = "ztyyobiv250";
    public static final String ZTYYOBIV60               = "ztyyobiv60";
    public static final String ZTYANSYUYOUYOBIN10X7     = "ztyansyuyouyobin10x7";

    private final PKZT_KouzahuriMinyuTuutiTy primaryKey;

    public GenZT_KouzahuriMinyuTuutiTy() {
        primaryKey = new PKZT_KouzahuriMinyuTuutiTy();
    }

    public GenZT_KouzahuriMinyuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_KouzahuriMinyuTuutiTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_KouzahuriMinyuTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KouzahuriMinyuTuutiTy> getMetaClass() {
        return QZT_KouzahuriMinyuTuutiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyyobiv9;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv61;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV61)
    public String getZtyyobiv61() {
        return ztyyobiv61;
    }

    public void setZtyyobiv61(String pZtyyobiv61) {
        ztyyobiv61 = pZtyyobiv61;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztytuutinm30keta;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYTUUTINM30KETA)
    public String getZtytuutinm30keta() {
        return ztytuutinm30keta;
    }

    public void setZtytuutinm30keta(String pZtytuutinm30keta) {
        ztytuutinm30keta = pZtytuutinm30keta;
    }

    private String ztyminyuttmsg1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG1)
    public String getZtyminyuttmsg1() {
        return ztyminyuttmsg1;
    }

    public void setZtyminyuttmsg1(String pZtyminyuttmsg1) {
        ztyminyuttmsg1 = pZtyminyuttmsg1;
    }

    private String ztyminyuttmsg2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG2)
    public String getZtyminyuttmsg2() {
        return ztyminyuttmsg2;
    }

    public void setZtyminyuttmsg2(String pZtyminyuttmsg2) {
        ztyminyuttmsg2 = pZtyminyuttmsg2;
    }

    private String ztyminyuttmsg3;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG3)
    public String getZtyminyuttmsg3() {
        return ztyminyuttmsg3;
    }

    public void setZtyminyuttmsg3(String pZtyminyuttmsg3) {
        ztyminyuttmsg3 = pZtyminyuttmsg3;
    }

    private String ztyminyuttmsg4;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG4)
    public String getZtyminyuttmsg4() {
        return ztyminyuttmsg4;
    }

    public void setZtyminyuttmsg4(String pZtyminyuttmsg4) {
        ztyminyuttmsg4 = pZtyminyuttmsg4;
    }

    private String ztyminyuttmsg5;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG5)
    public String getZtyminyuttmsg5() {
        return ztyminyuttmsg5;
    }

    public void setZtyminyuttmsg5(String pZtyminyuttmsg5) {
        ztyminyuttmsg5 = pZtyminyuttmsg5;
    }

    private String ztyminyuttmsg6;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG6)
    public String getZtyminyuttmsg6() {
        return ztyminyuttmsg6;
    }

    public void setZtyminyuttmsg6(String pZtyminyuttmsg6) {
        ztyminyuttmsg6 = pZtyminyuttmsg6;
    }

    private String ztyminyuttmsg7;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG7)
    public String getZtyminyuttmsg7() {
        return ztyminyuttmsg7;
    }

    public void setZtyminyuttmsg7(String pZtyminyuttmsg7) {
        ztyminyuttmsg7 = pZtyminyuttmsg7;
    }

    private String ztyminyuttmsg8;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG8)
    public String getZtyminyuttmsg8() {
        return ztyminyuttmsg8;
    }

    public void setZtyminyuttmsg8(String pZtyminyuttmsg8) {
        ztyminyuttmsg8 = pZtyminyuttmsg8;
    }

    private String ztyminyuttmsg9;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG9)
    public String getZtyminyuttmsg9() {
        return ztyminyuttmsg9;
    }

    public void setZtyminyuttmsg9(String pZtyminyuttmsg9) {
        ztyminyuttmsg9 = pZtyminyuttmsg9;
    }

    private String ztyminyuttmsg10;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG10)
    public String getZtyminyuttmsg10() {
        return ztyminyuttmsg10;
    }

    public void setZtyminyuttmsg10(String pZtyminyuttmsg10) {
        ztyminyuttmsg10 = pZtyminyuttmsg10;
    }

    private String ztyminyuttmsg11;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG11)
    public String getZtyminyuttmsg11() {
        return ztyminyuttmsg11;
    }

    public void setZtyminyuttmsg11(String pZtyminyuttmsg11) {
        ztyminyuttmsg11 = pZtyminyuttmsg11;
    }

    private String ztyminyuttmsg12;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTMSG12)
    public String getZtyminyuttmsg12() {
        return ztyminyuttmsg12;
    }

    public void setZtyminyuttmsg12(String pZtyminyuttmsg12) {
        ztyminyuttmsg12 = pZtyminyuttmsg12;
    }

    private String ztyyobiv174;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV174)
    public String getZtyyobiv174() {
        return ztyyobiv174;
    }

    public void setZtyyobiv174(String pZtyyobiv174) {
        ztyyobiv174 = pZtyyobiv174;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztypannainm;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYPANNAINM)
    public String getZtypannainm() {
        return ztypannainm;
    }

    public void setZtypannainm(String pZtypannainm) {
        ztypannainm = pZtypannainm;
    }

    private String ztyhrkhou12keta;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHRKHOU12KETA)
    public String getZtyhrkhou12keta() {
        return ztyhrkhou12keta;
    }

    public void setZtyhrkhou12keta(String pZtyhrkhou12keta) {
        ztyhrkhou12keta = pZtyhrkhou12keta;
    }

    private String ztysyono2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztynextkzhrnaiyou1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYNEXTKZHRNAIYOU1)
    public String getZtynextkzhrnaiyou1() {
        return ztynextkzhrnaiyou1;
    }

    public void setZtynextkzhrnaiyou1(String pZtynextkzhrnaiyou1) {
        ztynextkzhrnaiyou1 = pZtynextkzhrnaiyou1;
    }

    private String ztynextkzhrnaiyou2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYNEXTKZHRNAIYOU2)
    public String getZtynextkzhrnaiyou2() {
        return ztynextkzhrnaiyou2;
    }

    public void setZtynextkzhrnaiyou2(String pZtynextkzhrnaiyou2) {
        ztynextkzhrnaiyou2 = pZtynextkzhrnaiyou2;
    }

    private String ztynextkzhrnaiyou3;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYNEXTKZHRNAIYOU3)
    public String getZtynextkzhrnaiyou3() {
        return ztynextkzhrnaiyou3;
    }

    public void setZtynextkzhrnaiyou3(String pZtynextkzhrnaiyou3) {
        ztynextkzhrnaiyou3 = pZtynextkzhrnaiyou3;
    }

    private String ztysaikokuyykk1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSAIKOKUYYKK1)
    public String getZtysaikokuyykk1() {
        return ztysaikokuyykk1;
    }

    public void setZtysaikokuyykk1(String pZtysaikokuyykk1) {
        ztysaikokuyykk1 = pZtysaikokuyykk1;
    }

    private String ztysaikokuyykk2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYSAIKOKUYYKK2)
    public String getZtysaikokuyykk2() {
        return ztysaikokuyykk2;
    }

    public void setZtysaikokuyykk2(String pZtysaikokuyykk2) {
        ztysaikokuyykk2 = pZtysaikokuyykk2;
    }

    private String ztyhrkmiraimsg1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHRKMIRAIMSG1)
    public String getZtyhrkmiraimsg1() {
        return ztyhrkmiraimsg1;
    }

    public void setZtyhrkmiraimsg1(String pZtyhrkmiraimsg1) {
        ztyhrkmiraimsg1 = pZtyhrkmiraimsg1;
    }

    private String ztyhrkmiraimsg2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHRKMIRAIMSG2)
    public String getZtyhrkmiraimsg2() {
        return ztyhrkmiraimsg2;
    }

    public void setZtyhrkmiraimsg2(String pZtyhrkmiraimsg2) {
        ztyhrkmiraimsg2 = pZtyhrkmiraimsg2;
    }

    private String ztyhrkmiraimsg3;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHRKMIRAIMSG3)
    public String getZtyhrkmiraimsg3() {
        return ztyhrkmiraimsg3;
    }

    public void setZtyhrkmiraimsg3(String pZtyhrkmiraimsg3) {
        ztyhrkmiraimsg3 = pZtyhrkmiraimsg3;
    }

    private String ztyzenhurinaiyou1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYZENHURINAIYOU1)
    public String getZtyzenhurinaiyou1() {
        return ztyzenhurinaiyou1;
    }

    public void setZtyzenhurinaiyou1(String pZtyzenhurinaiyou1) {
        ztyzenhurinaiyou1 = pZtyzenhurinaiyou1;
    }

    private String ztyzenhurinaiyou2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYZENHURINAIYOU2)
    public String getZtyzenhurinaiyou2() {
        return ztyzenhurinaiyou2;
    }

    public void setZtyzenhurinaiyou2(String pZtyzenhurinaiyou2) {
        ztyzenhurinaiyou2 = pZtyzenhurinaiyou2;
    }

    private String ztyzenhurinaiyou3;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYZENHURINAIYOU3)
    public String getZtyzenhurinaiyou3() {
        return ztyzenhurinaiyou3;
    }

    public void setZtyzenhurinaiyou3(String pZtyzenhurinaiyou3) {
        ztyzenhurinaiyou3 = pZtyzenhurinaiyou3;
    }

    private String ztyzenhurinaiyou4;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYZENHURINAIYOU4)
    public String getZtyzenhurinaiyou4() {
        return ztyzenhurinaiyou4;
    }

    public void setZtyzenhurinaiyou4(String pZtyzenhurinaiyou4) {
        ztyzenhurinaiyou4 = pZtyzenhurinaiyou4;
    }

    private String ztyyobiv196;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV196)
    public String getZtyyobiv196() {
        return ztyyobiv196;
    }

    public void setZtyyobiv196(String pZtyyobiv196) {
        ztyyobiv196 = pZtyyobiv196;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }

    private String ztyhurikaekz37keta1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHURIKAEKZ37KETA1)
    public String getZtyhurikaekz37keta1() {
        return ztyhurikaekz37keta1;
    }

    public void setZtyhurikaekz37keta1(String pZtyhurikaekz37keta1) {
        ztyhurikaekz37keta1 = pZtyhurikaekz37keta1;
    }

    private String ztyhurikaekz37keta2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHURIKAEKZ37KETA2)
    public String getZtyhurikaekz37keta2() {
        return ztyhurikaekz37keta2;
    }

    public void setZtyhurikaekz37keta2(String pZtyhurikaekz37keta2) {
        ztyhurikaekz37keta2 = pZtyhurikaekz37keta2;
    }

    private String ztyhurikaekz37keta3;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHURIKAEKZ37KETA3)
    public String getZtyhurikaekz37keta3() {
        return ztyhurikaekz37keta3;
    }

    public void setZtyhurikaekz37keta3(String pZtyhurikaekz37keta3) {
        ztyhurikaekz37keta3 = pZtyhurikaekz37keta3;
    }

    private String ztyhurikaekz37keta4;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHURIKAEKZ37KETA4)
    public String getZtyhurikaekz37keta4() {
        return ztyhurikaekz37keta4;
    }

    public void setZtyhurikaekz37keta4(String pZtyhurikaekz37keta4) {
        ztyhurikaekz37keta4 = pZtyhurikaekz37keta4;
    }

    private String ztyhurikaekz37keta5;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHURIKAEKZ37KETA5)
    public String getZtyhurikaekz37keta5() {
        return ztyhurikaekz37keta5;
    }

    public void setZtyhurikaekz37keta5(String pZtyhurikaekz37keta5) {
        ztyhurikaekz37keta5 = pZtyhurikaekz37keta5;
    }

    private String ztyhurikaekz37keta6;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYHURIKAEKZ37KETA6)
    public String getZtyhurikaekz37keta6() {
        return ztyhurikaekz37keta6;
    }

    public void setZtyhurikaekz37keta6(String pZtyhurikaekz37keta6) {
        ztyhurikaekz37keta6 = pZtyhurikaekz37keta6;
    }

    private String ztyyobiv88;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV88)
    public String getZtyyobiv88() {
        return ztyyobiv88;
    }

    public void setZtyyobiv88(String pZtyyobiv88) {
        ztyyobiv88 = pZtyyobiv88;
    }

    private String ztyansyuyouyobin10x6;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYANSYUYOUYOBIN10X6)
    public String getZtyansyuyouyobin10x6() {
        return ztyansyuyouyobin10x6;
    }

    public void setZtyansyuyouyobin10x6(String pZtyansyuyouyobin10x6) {
        ztyansyuyouyobin10x6 = pZtyansyuyouyobin10x6;
    }

    private String ztyminyuttaddmsg1;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG1)
    public String getZtyminyuttaddmsg1() {
        return ztyminyuttaddmsg1;
    }

    public void setZtyminyuttaddmsg1(String pZtyminyuttaddmsg1) {
        ztyminyuttaddmsg1 = pZtyminyuttaddmsg1;
    }

    private String ztyminyuttaddmsg2;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG2)
    public String getZtyminyuttaddmsg2() {
        return ztyminyuttaddmsg2;
    }

    public void setZtyminyuttaddmsg2(String pZtyminyuttaddmsg2) {
        ztyminyuttaddmsg2 = pZtyminyuttaddmsg2;
    }

    private String ztyminyuttaddmsg3;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG3)
    public String getZtyminyuttaddmsg3() {
        return ztyminyuttaddmsg3;
    }

    public void setZtyminyuttaddmsg3(String pZtyminyuttaddmsg3) {
        ztyminyuttaddmsg3 = pZtyminyuttaddmsg3;
    }

    private String ztyminyuttaddmsg4;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG4)
    public String getZtyminyuttaddmsg4() {
        return ztyminyuttaddmsg4;
    }

    public void setZtyminyuttaddmsg4(String pZtyminyuttaddmsg4) {
        ztyminyuttaddmsg4 = pZtyminyuttaddmsg4;
    }

    private String ztyminyuttaddmsg5;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG5)
    public String getZtyminyuttaddmsg5() {
        return ztyminyuttaddmsg5;
    }

    public void setZtyminyuttaddmsg5(String pZtyminyuttaddmsg5) {
        ztyminyuttaddmsg5 = pZtyminyuttaddmsg5;
    }

    private String ztyminyuttaddmsg6;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG6)
    public String getZtyminyuttaddmsg6() {
        return ztyminyuttaddmsg6;
    }

    public void setZtyminyuttaddmsg6(String pZtyminyuttaddmsg6) {
        ztyminyuttaddmsg6 = pZtyminyuttaddmsg6;
    }

    private String ztyminyuttaddmsg7;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG7)
    public String getZtyminyuttaddmsg7() {
        return ztyminyuttaddmsg7;
    }

    public void setZtyminyuttaddmsg7(String pZtyminyuttaddmsg7) {
        ztyminyuttaddmsg7 = pZtyminyuttaddmsg7;
    }

    private String ztyminyuttaddmsg8;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG8)
    public String getZtyminyuttaddmsg8() {
        return ztyminyuttaddmsg8;
    }

    public void setZtyminyuttaddmsg8(String pZtyminyuttaddmsg8) {
        ztyminyuttaddmsg8 = pZtyminyuttaddmsg8;
    }

    private String ztyminyuttaddmsg9;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG9)
    public String getZtyminyuttaddmsg9() {
        return ztyminyuttaddmsg9;
    }

    public void setZtyminyuttaddmsg9(String pZtyminyuttaddmsg9) {
        ztyminyuttaddmsg9 = pZtyminyuttaddmsg9;
    }

    private String ztyminyuttaddmsg10;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG10)
    public String getZtyminyuttaddmsg10() {
        return ztyminyuttaddmsg10;
    }

    public void setZtyminyuttaddmsg10(String pZtyminyuttaddmsg10) {
        ztyminyuttaddmsg10 = pZtyminyuttaddmsg10;
    }

    private String ztyminyuttaddmsg11;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG11)
    public String getZtyminyuttaddmsg11() {
        return ztyminyuttaddmsg11;
    }

    public void setZtyminyuttaddmsg11(String pZtyminyuttaddmsg11) {
        ztyminyuttaddmsg11 = pZtyminyuttaddmsg11;
    }

    private String ztyminyuttaddmsg12;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG12)
    public String getZtyminyuttaddmsg12() {
        return ztyminyuttaddmsg12;
    }

    public void setZtyminyuttaddmsg12(String pZtyminyuttaddmsg12) {
        ztyminyuttaddmsg12 = pZtyminyuttaddmsg12;
    }

    private String ztyminyuttaddmsg13;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG13)
    public String getZtyminyuttaddmsg13() {
        return ztyminyuttaddmsg13;
    }

    public void setZtyminyuttaddmsg13(String pZtyminyuttaddmsg13) {
        ztyminyuttaddmsg13 = pZtyminyuttaddmsg13;
    }

    private String ztyminyuttaddmsg14;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG14)
    public String getZtyminyuttaddmsg14() {
        return ztyminyuttaddmsg14;
    }

    public void setZtyminyuttaddmsg14(String pZtyminyuttaddmsg14) {
        ztyminyuttaddmsg14 = pZtyminyuttaddmsg14;
    }

    private String ztyminyuttaddmsg15;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG15)
    public String getZtyminyuttaddmsg15() {
        return ztyminyuttaddmsg15;
    }

    public void setZtyminyuttaddmsg15(String pZtyminyuttaddmsg15) {
        ztyminyuttaddmsg15 = pZtyminyuttaddmsg15;
    }

    private String ztyminyuttaddmsg16;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG16)
    public String getZtyminyuttaddmsg16() {
        return ztyminyuttaddmsg16;
    }

    public void setZtyminyuttaddmsg16(String pZtyminyuttaddmsg16) {
        ztyminyuttaddmsg16 = pZtyminyuttaddmsg16;
    }

    private String ztyminyuttaddmsg17;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG17)
    public String getZtyminyuttaddmsg17() {
        return ztyminyuttaddmsg17;
    }

    public void setZtyminyuttaddmsg17(String pZtyminyuttaddmsg17) {
        ztyminyuttaddmsg17 = pZtyminyuttaddmsg17;
    }

    private String ztyminyuttaddmsg18;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG18)
    public String getZtyminyuttaddmsg18() {
        return ztyminyuttaddmsg18;
    }

    public void setZtyminyuttaddmsg18(String pZtyminyuttaddmsg18) {
        ztyminyuttaddmsg18 = pZtyminyuttaddmsg18;
    }

    private String ztyminyuttaddmsg19;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG19)
    public String getZtyminyuttaddmsg19() {
        return ztyminyuttaddmsg19;
    }

    public void setZtyminyuttaddmsg19(String pZtyminyuttaddmsg19) {
        ztyminyuttaddmsg19 = pZtyminyuttaddmsg19;
    }

    private String ztyminyuttaddmsg20;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG20)
    public String getZtyminyuttaddmsg20() {
        return ztyminyuttaddmsg20;
    }

    public void setZtyminyuttaddmsg20(String pZtyminyuttaddmsg20) {
        ztyminyuttaddmsg20 = pZtyminyuttaddmsg20;
    }

    private String ztyminyuttaddmsg21;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYMINYUTTADDMSG21)
    public String getZtyminyuttaddmsg21() {
        return ztyminyuttaddmsg21;
    }

    public void setZtyminyuttaddmsg21(String pZtyminyuttaddmsg21) {
        ztyminyuttaddmsg21 = pZtyminyuttaddmsg21;
    }

    private String ztyyobiv250;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV250)
    public String getZtyyobiv250() {
        return ztyyobiv250;
    }

    public void setZtyyobiv250(String pZtyyobiv250) {
        ztyyobiv250 = pZtyyobiv250;
    }

    private String ztyyobiv60;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYYOBIV60)
    public String getZtyyobiv60() {
        return ztyyobiv60;
    }

    public void setZtyyobiv60(String pZtyyobiv60) {
        ztyyobiv60 = pZtyyobiv60;
    }

    private String ztyansyuyouyobin10x7;

    @Column(name=GenZT_KouzahuriMinyuTuutiTy.ZTYANSYUYOUYOBIN10X7)
    public String getZtyansyuyouyobin10x7() {
        return ztyansyuyouyobin10x7;
    }

    public void setZtyansyuyouyobin10x7(String pZtyansyuyouyobin10x7) {
        ztyansyuyouyobin10x7 = pZtyansyuyouyobin10x7;
    }
}