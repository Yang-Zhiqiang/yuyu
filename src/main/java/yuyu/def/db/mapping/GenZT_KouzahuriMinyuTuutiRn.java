package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.id.PKZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.GenQZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiRn;

/**
 * 口座振替未入通知テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KouzahuriMinyuTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriMinyuTuutiRn}</td><td colspan="3">口座振替未入通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_KouzahuriMinyuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KouzahuriMinyuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10 zrnansyuyouyobin10}</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkj zrnshsnmkj}</td><td>（連携用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv43 zrnyobiv43}</td><td>（連携用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x2 zrnansyuyouyobin10x2}</td><td>（連携用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawsosikikj zrntawsosikikj}</td><td>（連携用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj zrntawadr1kj}</td><td>（連携用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj zrntawadr2kj}</td><td>（連携用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr3kj zrntawadr3kj}</td><td>（連携用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelnov14 zrntawtelnov14}</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou1 zrntawteluktkkanou1}</td><td>（連携用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou2 zrntawteluktkkanou2}</td><td>（連携用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawsosikinmkj zrndai2tawsosikinmkj}</td><td>（連携用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawtelno zrndai2tawtelno}</td><td>（連携用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclatosyono zrnsclatosyono}</td><td>（連携用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakunm15keta zrnsakunm15keta}</td><td>（連携用）作成番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv61 zrnyobiv61}</td><td>（連携用）予備項目Ｖ６１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutinm30keta zrntuutinm30keta}</td><td>（連携用）通知名称（３０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg1 zrnminyuttmsg1}</td><td>（連携用）未入通知メッセージ１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg2 zrnminyuttmsg2}</td><td>（連携用）未入通知メッセージ２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg3 zrnminyuttmsg3}</td><td>（連携用）未入通知メッセージ３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg4 zrnminyuttmsg4}</td><td>（連携用）未入通知メッセージ４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg5 zrnminyuttmsg5}</td><td>（連携用）未入通知メッセージ５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg6 zrnminyuttmsg6}</td><td>（連携用）未入通知メッセージ６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg7 zrnminyuttmsg7}</td><td>（連携用）未入通知メッセージ７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg8 zrnminyuttmsg8}</td><td>（連携用）未入通知メッセージ８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg9 zrnminyuttmsg9}</td><td>（連携用）未入通知メッセージ９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg10 zrnminyuttmsg10}</td><td>（連携用）未入通知メッセージ１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg11 zrnminyuttmsg11}</td><td>（連携用）未入通知メッセージ１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttmsg12 zrnminyuttmsg12}</td><td>（連携用）未入通知メッセージ１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv174 zrnyobiv174}</td><td>（連携用）予備項目Ｖ１７４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpannainm zrnpannainm}</td><td>（連携用）保険料案内名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhou12keta zrnhrkhou12keta}</td><td>（連携用）払込方法（１２桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnextkzhrnaiyou1 zrnnextkzhrnaiyou1}</td><td>（連携用）次回振替内容１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnextkzhrnaiyou2 zrnnextkzhrnaiyou2}</td><td>（連携用）次回振替内容２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnextkzhrnaiyou3 zrnnextkzhrnaiyou3}</td><td>（連携用）次回振替内容３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaikokuyykk1 zrnsaikokuyykk1}</td><td>（連携用）催告月猶予期間１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaikokuyykk2 zrnsaikokuyykk2}</td><td>（連携用）催告月猶予期間２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmiraimsg1 zrnhrkmiraimsg1}</td><td>（連携用）振込依頼メッセージ１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmiraimsg2 zrnhrkmiraimsg2}</td><td>（連携用）振込依頼メッセージ２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmiraimsg3 zrnhrkmiraimsg3}</td><td>（連携用）振込依頼メッセージ３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenhurinaiyou1 zrnzenhurinaiyou1}</td><td>（連携用）前回振替内容１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenhurinaiyou2 zrnzenhurinaiyou2}</td><td>（連携用）前回振替内容２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenhurinaiyou3 zrnzenhurinaiyou3}</td><td>（連携用）前回振替内容３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenhurinaiyou4 zrnzenhurinaiyou4}</td><td>（連携用）前回振替内容４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv196 zrnyobiv196}</td><td>（連携用）予備項目Ｖ１９６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz37keta1 zrnhurikaekz37keta1}</td><td>（連携用）振替口座（３７桁）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz37keta2 zrnhurikaekz37keta2}</td><td>（連携用）振替口座（３７桁）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz37keta3 zrnhurikaekz37keta3}</td><td>（連携用）振替口座（３７桁）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz37keta4 zrnhurikaekz37keta4}</td><td>（連携用）振替口座（３７桁）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz37keta5 zrnhurikaekz37keta5}</td><td>（連携用）振替口座（３７桁）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz37keta6 zrnhurikaekz37keta6}</td><td>（連携用）振替口座（３７桁）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv88 zrnyobiv88}</td><td>（連携用）予備項目Ｖ８８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x6 zrnansyuyouyobin10x6}</td><td>（連携用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg1 zrnminyuttaddmsg1}</td><td>（連携用）未入通知追加メッセージ１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg2 zrnminyuttaddmsg2}</td><td>（連携用）未入通知追加メッセージ２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg3 zrnminyuttaddmsg3}</td><td>（連携用）未入通知追加メッセージ３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg4 zrnminyuttaddmsg4}</td><td>（連携用）未入通知追加メッセージ４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg5 zrnminyuttaddmsg5}</td><td>（連携用）未入通知追加メッセージ５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg6 zrnminyuttaddmsg6}</td><td>（連携用）未入通知追加メッセージ６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg7 zrnminyuttaddmsg7}</td><td>（連携用）未入通知追加メッセージ７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg8 zrnminyuttaddmsg8}</td><td>（連携用）未入通知追加メッセージ８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg9 zrnminyuttaddmsg9}</td><td>（連携用）未入通知追加メッセージ９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg10 zrnminyuttaddmsg10}</td><td>（連携用）未入通知追加メッセージ１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg11 zrnminyuttaddmsg11}</td><td>（連携用）未入通知追加メッセージ１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg12 zrnminyuttaddmsg12}</td><td>（連携用）未入通知追加メッセージ１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg13 zrnminyuttaddmsg13}</td><td>（連携用）未入通知追加メッセージ１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg14 zrnminyuttaddmsg14}</td><td>（連携用）未入通知追加メッセージ１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg15 zrnminyuttaddmsg15}</td><td>（連携用）未入通知追加メッセージ１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg16 zrnminyuttaddmsg16}</td><td>（連携用）未入通知追加メッセージ１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg17 zrnminyuttaddmsg17}</td><td>（連携用）未入通知追加メッセージ１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg18 zrnminyuttaddmsg18}</td><td>（連携用）未入通知追加メッセージ１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg19 zrnminyuttaddmsg19}</td><td>（連携用）未入通知追加メッセージ１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg20 zrnminyuttaddmsg20}</td><td>（連携用）未入通知追加メッセージ２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuttaddmsg21 zrnminyuttaddmsg21}</td><td>（連携用）未入通知追加メッセージ２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250 zrnyobiv250}</td><td>（連携用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv60 zrnyobiv60}</td><td>（連携用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x7 zrnansyuyouyobin10x7}</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriMinyuTuutiRn
 * @see     PKZT_KouzahuriMinyuTuutiRn
 * @see     QZT_KouzahuriMinyuTuutiRn
 * @see     GenQZT_KouzahuriMinyuTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_KouzahuriMinyuTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_KouzahuriMinyuTuutiRn.class)
public abstract class GenZT_KouzahuriMinyuTuutiRn extends AbstractExDBEntityForZDB<ZT_KouzahuriMinyuTuutiRn, PKZT_KouzahuriMinyuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KouzahuriMinyuTuutiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDKJ         = "zrntyouhyouymdkj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNANSYUYOUYOBIN10       = "zrnansyuyouyobin10";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJ               = "zrnshsnmkj";
    public static final String ZRNYOBIV43               = "zrnyobiv43";
    public static final String ZRNANSYUYOUYOBIN10X2     = "zrnansyuyouyobin10x2";
    public static final String ZRNTAWSOSIKIKJ           = "zrntawsosikikj";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ             = "zrntawadr1kj";
    public static final String ZRNTAWADR2KJ             = "zrntawadr2kj";
    public static final String ZRNTAWADR3KJ             = "zrntawadr3kj";
    public static final String ZRNTAWTELNOV14           = "zrntawtelnov14";
    public static final String ZRNTAWTELUKTKKANOU1      = "zrntawteluktkkanou1";
    public static final String ZRNTAWTELUKTKKANOU2      = "zrntawteluktkkanou2";
    public static final String ZRNDAI2TAWSOSIKINMKJ     = "zrndai2tawsosikinmkj";
    public static final String ZRNDAI2TAWTELNO          = "zrndai2tawtelno";
    public static final String ZRNSCLATOSYONO           = "zrnsclatosyono";
    public static final String ZRNSAKUNM15KETA          = "zrnsakunm15keta";
    public static final String ZRNYOBIV61               = "zrnyobiv61";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNTUUTINM30KETA         = "zrntuutinm30keta";
    public static final String ZRNMINYUTTMSG1           = "zrnminyuttmsg1";
    public static final String ZRNMINYUTTMSG2           = "zrnminyuttmsg2";
    public static final String ZRNMINYUTTMSG3           = "zrnminyuttmsg3";
    public static final String ZRNMINYUTTMSG4           = "zrnminyuttmsg4";
    public static final String ZRNMINYUTTMSG5           = "zrnminyuttmsg5";
    public static final String ZRNMINYUTTMSG6           = "zrnminyuttmsg6";
    public static final String ZRNMINYUTTMSG7           = "zrnminyuttmsg7";
    public static final String ZRNMINYUTTMSG8           = "zrnminyuttmsg8";
    public static final String ZRNMINYUTTMSG9           = "zrnminyuttmsg9";
    public static final String ZRNMINYUTTMSG10          = "zrnminyuttmsg10";
    public static final String ZRNMINYUTTMSG11          = "zrnminyuttmsg11";
    public static final String ZRNMINYUTTMSG12          = "zrnminyuttmsg12";
    public static final String ZRNYOBIV174              = "zrnyobiv174";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNPANNAINM              = "zrnpannainm";
    public static final String ZRNHRKHOU12KETA          = "zrnhrkhou12keta";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNNEXTKZHRNAIYOU1       = "zrnnextkzhrnaiyou1";
    public static final String ZRNNEXTKZHRNAIYOU2       = "zrnnextkzhrnaiyou2";
    public static final String ZRNNEXTKZHRNAIYOU3       = "zrnnextkzhrnaiyou3";
    public static final String ZRNSAIKOKUYYKK1          = "zrnsaikokuyykk1";
    public static final String ZRNSAIKOKUYYKK2          = "zrnsaikokuyykk2";
    public static final String ZRNHRKMIRAIMSG1          = "zrnhrkmiraimsg1";
    public static final String ZRNHRKMIRAIMSG2          = "zrnhrkmiraimsg2";
    public static final String ZRNHRKMIRAIMSG3          = "zrnhrkmiraimsg3";
    public static final String ZRNZENHURINAIYOU1        = "zrnzenhurinaiyou1";
    public static final String ZRNZENHURINAIYOU2        = "zrnzenhurinaiyou2";
    public static final String ZRNZENHURINAIYOU3        = "zrnzenhurinaiyou3";
    public static final String ZRNZENHURINAIYOU4        = "zrnzenhurinaiyou4";
    public static final String ZRNYOBIV196              = "zrnyobiv196";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";
    public static final String ZRNHURIKAEKZ37KETA1      = "zrnhurikaekz37keta1";
    public static final String ZRNHURIKAEKZ37KETA2      = "zrnhurikaekz37keta2";
    public static final String ZRNHURIKAEKZ37KETA3      = "zrnhurikaekz37keta3";
    public static final String ZRNHURIKAEKZ37KETA4      = "zrnhurikaekz37keta4";
    public static final String ZRNHURIKAEKZ37KETA5      = "zrnhurikaekz37keta5";
    public static final String ZRNHURIKAEKZ37KETA6      = "zrnhurikaekz37keta6";
    public static final String ZRNYOBIV88               = "zrnyobiv88";
    public static final String ZRNANSYUYOUYOBIN10X6     = "zrnansyuyouyobin10x6";
    public static final String ZRNMINYUTTADDMSG1        = "zrnminyuttaddmsg1";
    public static final String ZRNMINYUTTADDMSG2        = "zrnminyuttaddmsg2";
    public static final String ZRNMINYUTTADDMSG3        = "zrnminyuttaddmsg3";
    public static final String ZRNMINYUTTADDMSG4        = "zrnminyuttaddmsg4";
    public static final String ZRNMINYUTTADDMSG5        = "zrnminyuttaddmsg5";
    public static final String ZRNMINYUTTADDMSG6        = "zrnminyuttaddmsg6";
    public static final String ZRNMINYUTTADDMSG7        = "zrnminyuttaddmsg7";
    public static final String ZRNMINYUTTADDMSG8        = "zrnminyuttaddmsg8";
    public static final String ZRNMINYUTTADDMSG9        = "zrnminyuttaddmsg9";
    public static final String ZRNMINYUTTADDMSG10       = "zrnminyuttaddmsg10";
    public static final String ZRNMINYUTTADDMSG11       = "zrnminyuttaddmsg11";
    public static final String ZRNMINYUTTADDMSG12       = "zrnminyuttaddmsg12";
    public static final String ZRNMINYUTTADDMSG13       = "zrnminyuttaddmsg13";
    public static final String ZRNMINYUTTADDMSG14       = "zrnminyuttaddmsg14";
    public static final String ZRNMINYUTTADDMSG15       = "zrnminyuttaddmsg15";
    public static final String ZRNMINYUTTADDMSG16       = "zrnminyuttaddmsg16";
    public static final String ZRNMINYUTTADDMSG17       = "zrnminyuttaddmsg17";
    public static final String ZRNMINYUTTADDMSG18       = "zrnminyuttaddmsg18";
    public static final String ZRNMINYUTTADDMSG19       = "zrnminyuttaddmsg19";
    public static final String ZRNMINYUTTADDMSG20       = "zrnminyuttaddmsg20";
    public static final String ZRNMINYUTTADDMSG21       = "zrnminyuttaddmsg21";
    public static final String ZRNYOBIV250              = "zrnyobiv250";
    public static final String ZRNYOBIV60               = "zrnyobiv60";
    public static final String ZRNANSYUYOUYOBIN10X7     = "zrnansyuyouyobin10x7";

    private final PKZT_KouzahuriMinyuTuutiRn primaryKey;

    public GenZT_KouzahuriMinyuTuutiRn() {
        primaryKey = new PKZT_KouzahuriMinyuTuutiRn();
    }

    public GenZT_KouzahuriMinyuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_KouzahuriMinyuTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_KouzahuriMinyuTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KouzahuriMinyuTuutiRn> getMetaClass() {
        return QZT_KouzahuriMinyuTuutiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnyobiv9;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv61;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV61)
    public String getZrnyobiv61() {
        return zrnyobiv61;
    }

    public void setZrnyobiv61(String pZrnyobiv61) {
        zrnyobiv61 = pZrnyobiv61;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrntuutinm30keta;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNTUUTINM30KETA)
    public String getZrntuutinm30keta() {
        return zrntuutinm30keta;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutinm30keta(String pZrntuutinm30keta) {
        zrntuutinm30keta = pZrntuutinm30keta;
    }

    private String zrnminyuttmsg1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG1)
    public String getZrnminyuttmsg1() {
        return zrnminyuttmsg1;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg1(String pZrnminyuttmsg1) {
        zrnminyuttmsg1 = pZrnminyuttmsg1;
    }

    private String zrnminyuttmsg2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG2)
    public String getZrnminyuttmsg2() {
        return zrnminyuttmsg2;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg2(String pZrnminyuttmsg2) {
        zrnminyuttmsg2 = pZrnminyuttmsg2;
    }

    private String zrnminyuttmsg3;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG3)
    public String getZrnminyuttmsg3() {
        return zrnminyuttmsg3;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg3(String pZrnminyuttmsg3) {
        zrnminyuttmsg3 = pZrnminyuttmsg3;
    }

    private String zrnminyuttmsg4;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG4)
    public String getZrnminyuttmsg4() {
        return zrnminyuttmsg4;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg4(String pZrnminyuttmsg4) {
        zrnminyuttmsg4 = pZrnminyuttmsg4;
    }

    private String zrnminyuttmsg5;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG5)
    public String getZrnminyuttmsg5() {
        return zrnminyuttmsg5;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg5(String pZrnminyuttmsg5) {
        zrnminyuttmsg5 = pZrnminyuttmsg5;
    }

    private String zrnminyuttmsg6;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG6)
    public String getZrnminyuttmsg6() {
        return zrnminyuttmsg6;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg6(String pZrnminyuttmsg6) {
        zrnminyuttmsg6 = pZrnminyuttmsg6;
    }

    private String zrnminyuttmsg7;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG7)
    public String getZrnminyuttmsg7() {
        return zrnminyuttmsg7;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg7(String pZrnminyuttmsg7) {
        zrnminyuttmsg7 = pZrnminyuttmsg7;
    }

    private String zrnminyuttmsg8;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG8)
    public String getZrnminyuttmsg8() {
        return zrnminyuttmsg8;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg8(String pZrnminyuttmsg8) {
        zrnminyuttmsg8 = pZrnminyuttmsg8;
    }

    private String zrnminyuttmsg9;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG9)
    public String getZrnminyuttmsg9() {
        return zrnminyuttmsg9;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg9(String pZrnminyuttmsg9) {
        zrnminyuttmsg9 = pZrnminyuttmsg9;
    }

    private String zrnminyuttmsg10;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG10)
    public String getZrnminyuttmsg10() {
        return zrnminyuttmsg10;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg10(String pZrnminyuttmsg10) {
        zrnminyuttmsg10 = pZrnminyuttmsg10;
    }

    private String zrnminyuttmsg11;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG11)
    public String getZrnminyuttmsg11() {
        return zrnminyuttmsg11;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg11(String pZrnminyuttmsg11) {
        zrnminyuttmsg11 = pZrnminyuttmsg11;
    }

    private String zrnminyuttmsg12;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTMSG12)
    public String getZrnminyuttmsg12() {
        return zrnminyuttmsg12;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttmsg12(String pZrnminyuttmsg12) {
        zrnminyuttmsg12 = pZrnminyuttmsg12;
    }

    private String zrnyobiv174;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV174)
    public String getZrnyobiv174() {
        return zrnyobiv174;
    }

    public void setZrnyobiv174(String pZrnyobiv174) {
        zrnyobiv174 = pZrnyobiv174;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnpannainm;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNPANNAINM)
    public String getZrnpannainm() {
        return zrnpannainm;
    }

    @DataConvert("toMultiByte")
    public void setZrnpannainm(String pZrnpannainm) {
        zrnpannainm = pZrnpannainm;
    }

    private String zrnhrkhou12keta;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHRKHOU12KETA)
    public String getZrnhrkhou12keta() {
        return zrnhrkhou12keta;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkhou12keta(String pZrnhrkhou12keta) {
        zrnhrkhou12keta = pZrnhrkhou12keta;
    }

    private String zrnsyono2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnnextkzhrnaiyou1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNNEXTKZHRNAIYOU1)
    public String getZrnnextkzhrnaiyou1() {
        return zrnnextkzhrnaiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnnextkzhrnaiyou1(String pZrnnextkzhrnaiyou1) {
        zrnnextkzhrnaiyou1 = pZrnnextkzhrnaiyou1;
    }

    private String zrnnextkzhrnaiyou2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNNEXTKZHRNAIYOU2)
    public String getZrnnextkzhrnaiyou2() {
        return zrnnextkzhrnaiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnnextkzhrnaiyou2(String pZrnnextkzhrnaiyou2) {
        zrnnextkzhrnaiyou2 = pZrnnextkzhrnaiyou2;
    }

    private String zrnnextkzhrnaiyou3;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNNEXTKZHRNAIYOU3)
    public String getZrnnextkzhrnaiyou3() {
        return zrnnextkzhrnaiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnnextkzhrnaiyou3(String pZrnnextkzhrnaiyou3) {
        zrnnextkzhrnaiyou3 = pZrnnextkzhrnaiyou3;
    }

    private String zrnsaikokuyykk1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSAIKOKUYYKK1)
    public String getZrnsaikokuyykk1() {
        return zrnsaikokuyykk1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsaikokuyykk1(String pZrnsaikokuyykk1) {
        zrnsaikokuyykk1 = pZrnsaikokuyykk1;
    }

    private String zrnsaikokuyykk2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNSAIKOKUYYKK2)
    public String getZrnsaikokuyykk2() {
        return zrnsaikokuyykk2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsaikokuyykk2(String pZrnsaikokuyykk2) {
        zrnsaikokuyykk2 = pZrnsaikokuyykk2;
    }

    private String zrnhrkmiraimsg1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHRKMIRAIMSG1)
    public String getZrnhrkmiraimsg1() {
        return zrnhrkmiraimsg1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkmiraimsg1(String pZrnhrkmiraimsg1) {
        zrnhrkmiraimsg1 = pZrnhrkmiraimsg1;
    }

    private String zrnhrkmiraimsg2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHRKMIRAIMSG2)
    public String getZrnhrkmiraimsg2() {
        return zrnhrkmiraimsg2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkmiraimsg2(String pZrnhrkmiraimsg2) {
        zrnhrkmiraimsg2 = pZrnhrkmiraimsg2;
    }

    private String zrnhrkmiraimsg3;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHRKMIRAIMSG3)
    public String getZrnhrkmiraimsg3() {
        return zrnhrkmiraimsg3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkmiraimsg3(String pZrnhrkmiraimsg3) {
        zrnhrkmiraimsg3 = pZrnhrkmiraimsg3;
    }

    private String zrnzenhurinaiyou1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNZENHURINAIYOU1)
    public String getZrnzenhurinaiyou1() {
        return zrnzenhurinaiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnzenhurinaiyou1(String pZrnzenhurinaiyou1) {
        zrnzenhurinaiyou1 = pZrnzenhurinaiyou1;
    }

    private String zrnzenhurinaiyou2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNZENHURINAIYOU2)
    public String getZrnzenhurinaiyou2() {
        return zrnzenhurinaiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnzenhurinaiyou2(String pZrnzenhurinaiyou2) {
        zrnzenhurinaiyou2 = pZrnzenhurinaiyou2;
    }

    private String zrnzenhurinaiyou3;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNZENHURINAIYOU3)
    public String getZrnzenhurinaiyou3() {
        return zrnzenhurinaiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnzenhurinaiyou3(String pZrnzenhurinaiyou3) {
        zrnzenhurinaiyou3 = pZrnzenhurinaiyou3;
    }

    private String zrnzenhurinaiyou4;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNZENHURINAIYOU4)
    public String getZrnzenhurinaiyou4() {
        return zrnzenhurinaiyou4;
    }

    @DataConvert("toMultiByte")
    public void setZrnzenhurinaiyou4(String pZrnzenhurinaiyou4) {
        zrnzenhurinaiyou4 = pZrnzenhurinaiyou4;
    }

    private String zrnyobiv196;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV196)
    public String getZrnyobiv196() {
        return zrnyobiv196;
    }

    public void setZrnyobiv196(String pZrnyobiv196) {
        zrnyobiv196 = pZrnyobiv196;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }

    private String zrnhurikaekz37keta1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHURIKAEKZ37KETA1)
    public String getZrnhurikaekz37keta1() {
        return zrnhurikaekz37keta1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz37keta1(String pZrnhurikaekz37keta1) {
        zrnhurikaekz37keta1 = pZrnhurikaekz37keta1;
    }

    private String zrnhurikaekz37keta2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHURIKAEKZ37KETA2)
    public String getZrnhurikaekz37keta2() {
        return zrnhurikaekz37keta2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz37keta2(String pZrnhurikaekz37keta2) {
        zrnhurikaekz37keta2 = pZrnhurikaekz37keta2;
    }

    private String zrnhurikaekz37keta3;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHURIKAEKZ37KETA3)
    public String getZrnhurikaekz37keta3() {
        return zrnhurikaekz37keta3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz37keta3(String pZrnhurikaekz37keta3) {
        zrnhurikaekz37keta3 = pZrnhurikaekz37keta3;
    }

    private String zrnhurikaekz37keta4;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHURIKAEKZ37KETA4)
    public String getZrnhurikaekz37keta4() {
        return zrnhurikaekz37keta4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz37keta4(String pZrnhurikaekz37keta4) {
        zrnhurikaekz37keta4 = pZrnhurikaekz37keta4;
    }

    private String zrnhurikaekz37keta5;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHURIKAEKZ37KETA5)
    public String getZrnhurikaekz37keta5() {
        return zrnhurikaekz37keta5;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz37keta5(String pZrnhurikaekz37keta5) {
        zrnhurikaekz37keta5 = pZrnhurikaekz37keta5;
    }

    private String zrnhurikaekz37keta6;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNHURIKAEKZ37KETA6)
    public String getZrnhurikaekz37keta6() {
        return zrnhurikaekz37keta6;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz37keta6(String pZrnhurikaekz37keta6) {
        zrnhurikaekz37keta6 = pZrnhurikaekz37keta6;
    }

    private String zrnyobiv88;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV88)
    public String getZrnyobiv88() {
        return zrnyobiv88;
    }

    public void setZrnyobiv88(String pZrnyobiv88) {
        zrnyobiv88 = pZrnyobiv88;
    }

    private String zrnansyuyouyobin10x6;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNANSYUYOUYOBIN10X6)
    public String getZrnansyuyouyobin10x6() {
        return zrnansyuyouyobin10x6;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x6(String pZrnansyuyouyobin10x6) {
        zrnansyuyouyobin10x6 = pZrnansyuyouyobin10x6;
    }

    private String zrnminyuttaddmsg1;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG1)
    public String getZrnminyuttaddmsg1() {
        return zrnminyuttaddmsg1;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg1(String pZrnminyuttaddmsg1) {
        zrnminyuttaddmsg1 = pZrnminyuttaddmsg1;
    }

    private String zrnminyuttaddmsg2;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG2)
    public String getZrnminyuttaddmsg2() {
        return zrnminyuttaddmsg2;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg2(String pZrnminyuttaddmsg2) {
        zrnminyuttaddmsg2 = pZrnminyuttaddmsg2;
    }

    private String zrnminyuttaddmsg3;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG3)
    public String getZrnminyuttaddmsg3() {
        return zrnminyuttaddmsg3;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg3(String pZrnminyuttaddmsg3) {
        zrnminyuttaddmsg3 = pZrnminyuttaddmsg3;
    }

    private String zrnminyuttaddmsg4;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG4)
    public String getZrnminyuttaddmsg4() {
        return zrnminyuttaddmsg4;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg4(String pZrnminyuttaddmsg4) {
        zrnminyuttaddmsg4 = pZrnminyuttaddmsg4;
    }

    private String zrnminyuttaddmsg5;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG5)
    public String getZrnminyuttaddmsg5() {
        return zrnminyuttaddmsg5;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg5(String pZrnminyuttaddmsg5) {
        zrnminyuttaddmsg5 = pZrnminyuttaddmsg5;
    }

    private String zrnminyuttaddmsg6;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG6)
    public String getZrnminyuttaddmsg6() {
        return zrnminyuttaddmsg6;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg6(String pZrnminyuttaddmsg6) {
        zrnminyuttaddmsg6 = pZrnminyuttaddmsg6;
    }

    private String zrnminyuttaddmsg7;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG7)
    public String getZrnminyuttaddmsg7() {
        return zrnminyuttaddmsg7;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg7(String pZrnminyuttaddmsg7) {
        zrnminyuttaddmsg7 = pZrnminyuttaddmsg7;
    }

    private String zrnminyuttaddmsg8;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG8)
    public String getZrnminyuttaddmsg8() {
        return zrnminyuttaddmsg8;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg8(String pZrnminyuttaddmsg8) {
        zrnminyuttaddmsg8 = pZrnminyuttaddmsg8;
    }

    private String zrnminyuttaddmsg9;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG9)
    public String getZrnminyuttaddmsg9() {
        return zrnminyuttaddmsg9;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg9(String pZrnminyuttaddmsg9) {
        zrnminyuttaddmsg9 = pZrnminyuttaddmsg9;
    }

    private String zrnminyuttaddmsg10;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG10)
    public String getZrnminyuttaddmsg10() {
        return zrnminyuttaddmsg10;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg10(String pZrnminyuttaddmsg10) {
        zrnminyuttaddmsg10 = pZrnminyuttaddmsg10;
    }

    private String zrnminyuttaddmsg11;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG11)
    public String getZrnminyuttaddmsg11() {
        return zrnminyuttaddmsg11;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg11(String pZrnminyuttaddmsg11) {
        zrnminyuttaddmsg11 = pZrnminyuttaddmsg11;
    }

    private String zrnminyuttaddmsg12;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG12)
    public String getZrnminyuttaddmsg12() {
        return zrnminyuttaddmsg12;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg12(String pZrnminyuttaddmsg12) {
        zrnminyuttaddmsg12 = pZrnminyuttaddmsg12;
    }

    private String zrnminyuttaddmsg13;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG13)
    public String getZrnminyuttaddmsg13() {
        return zrnminyuttaddmsg13;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg13(String pZrnminyuttaddmsg13) {
        zrnminyuttaddmsg13 = pZrnminyuttaddmsg13;
    }

    private String zrnminyuttaddmsg14;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG14)
    public String getZrnminyuttaddmsg14() {
        return zrnminyuttaddmsg14;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg14(String pZrnminyuttaddmsg14) {
        zrnminyuttaddmsg14 = pZrnminyuttaddmsg14;
    }

    private String zrnminyuttaddmsg15;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG15)
    public String getZrnminyuttaddmsg15() {
        return zrnminyuttaddmsg15;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg15(String pZrnminyuttaddmsg15) {
        zrnminyuttaddmsg15 = pZrnminyuttaddmsg15;
    }

    private String zrnminyuttaddmsg16;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG16)
    public String getZrnminyuttaddmsg16() {
        return zrnminyuttaddmsg16;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg16(String pZrnminyuttaddmsg16) {
        zrnminyuttaddmsg16 = pZrnminyuttaddmsg16;
    }

    private String zrnminyuttaddmsg17;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG17)
    public String getZrnminyuttaddmsg17() {
        return zrnminyuttaddmsg17;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg17(String pZrnminyuttaddmsg17) {
        zrnminyuttaddmsg17 = pZrnminyuttaddmsg17;
    }

    private String zrnminyuttaddmsg18;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG18)
    public String getZrnminyuttaddmsg18() {
        return zrnminyuttaddmsg18;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg18(String pZrnminyuttaddmsg18) {
        zrnminyuttaddmsg18 = pZrnminyuttaddmsg18;
    }

    private String zrnminyuttaddmsg19;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG19)
    public String getZrnminyuttaddmsg19() {
        return zrnminyuttaddmsg19;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg19(String pZrnminyuttaddmsg19) {
        zrnminyuttaddmsg19 = pZrnminyuttaddmsg19;
    }

    private String zrnminyuttaddmsg20;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG20)
    public String getZrnminyuttaddmsg20() {
        return zrnminyuttaddmsg20;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg20(String pZrnminyuttaddmsg20) {
        zrnminyuttaddmsg20 = pZrnminyuttaddmsg20;
    }

    private String zrnminyuttaddmsg21;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNMINYUTTADDMSG21)
    public String getZrnminyuttaddmsg21() {
        return zrnminyuttaddmsg21;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuttaddmsg21(String pZrnminyuttaddmsg21) {
        zrnminyuttaddmsg21 = pZrnminyuttaddmsg21;
    }

    private String zrnyobiv250;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV250)
    public String getZrnyobiv250() {
        return zrnyobiv250;
    }

    public void setZrnyobiv250(String pZrnyobiv250) {
        zrnyobiv250 = pZrnyobiv250;
    }

    private String zrnyobiv60;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNYOBIV60)
    public String getZrnyobiv60() {
        return zrnyobiv60;
    }

    public void setZrnyobiv60(String pZrnyobiv60) {
        zrnyobiv60 = pZrnyobiv60;
    }

    private String zrnansyuyouyobin10x7;

    @Column(name=GenZT_KouzahuriMinyuTuutiRn.ZRNANSYUYOUYOBIN10X7)
    public String getZrnansyuyouyobin10x7() {
        return zrnansyuyouyobin10x7;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x7(String pZrnansyuyouyobin10x7) {
        zrnansyuyouyobin10x7 = pZrnansyuyouyobin10x7;
    }
}