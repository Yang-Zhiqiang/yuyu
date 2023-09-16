package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SiShrdetailTy;
import yuyu.def.db.mapping.GenZT_SiShrdetailTy;
import yuyu.def.db.meta.GenQZT_SiShrdetailTy;
import yuyu.def.db.meta.QZT_SiShrdetailTy;

/**
 * 保険金給付金支払明細書テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiShrdetailTy}</td><td colspan="3">保険金給付金支払明細書テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyodouhuukbn</td><td>（中継用）証券同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysikytkmkyobi1</td><td>（中継用）保険金共通項目予備１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskyno</td><td>（中継用）送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr1kj</td><td>（中継用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr2kj</td><td>（中継用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr3kj</td><td>（中継用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkjsimisi</td><td>（中継用）送付先名（漢字）（支払明細）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisituutimei</td><td>（中継用）支払明細書通知名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon1x1</td><td>（中継用）支払明細書お知らせ文言１－１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon1x2</td><td>（中継用）支払明細書お知らせ文言１－２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon2x1</td><td>（中継用）支払明細書お知らせ文言２－１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon2x2</td><td>（中継用）支払明細書お知らせ文言２－２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon2x3</td><td>（中継用）支払明細書お知らせ文言２－３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon2x4</td><td>（中継用）支払明細書お知らせ文言２－４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon2x5</td><td>（中継用）支払明細書お知らせ文言２－５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawyno</td><td>（中継用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr1kj30</td><td>（中継用）問合せ先住所１（漢字３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr2kj30</td><td>（中継用）問合せ先住所２（漢字３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr3kj30</td><td>（中継用）問合せ先住所３（漢字３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawtelno</td><td>（中継用）問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiatenabuyobi1</td><td>（中継用）支払明細書宛名部予備１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiatenabuyobi2</td><td>（中継用）支払明細書宛名部予備２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj</td><td>（中継用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymdwa</td><td>（中継用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaibiwareki</td><td>（中継用）支払日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybanknmkj</td><td>（中継用）銀行名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysitennmkj</td><td>（中継用）支店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokinsyumokumeikanji</td><td>（中継用）預金種目名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzano12keta</td><td>（中継用）口座番号（１２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzmeiginmkn</td><td>（中継用）口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzamaskingmsg</td><td>（中継用）口座マスキングＭＳＧ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisisummarybuyobi1</td><td>（中継用）支払明細書サマリー部予備１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisisummarybuyobi2</td><td>（中継用）支払明細書サマリー部予備２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyouranmidasi</td><td>（中継用）支払明細書摘要欄見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisairanmidasi</td><td>（中継用）支払金額明細欄見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisibikouranmidasi</td><td>（中継用）支払明細書備考欄見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibumidasiyobi</td><td>（中継用）支払明細書明細部見出し予備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou1</td><td>（中継用）支払明細書摘要１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi1</td><td>（中継用）支払明細書金額明細１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu1</td><td>（中継用）支払明細書金額明細通貨種類１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou1</td><td>（中継用）支払明細書明細備考１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou1</td><td>（中継用）支払明細書金額明細符号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi1</td><td>（中継用）支払明細書明細予備１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou2</td><td>（中継用）支払明細書摘要２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi2</td><td>（中継用）支払明細書金額明細２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu2</td><td>（中継用）支払明細書金額明細通貨種類２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou2</td><td>（中継用）支払明細書明細備考２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou2</td><td>（中継用）支払明細書金額明細符号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi2</td><td>（中継用）支払明細書明細予備２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou3</td><td>（中継用）支払明細書摘要３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi3</td><td>（中継用）支払明細書金額明細３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu3</td><td>（中継用）支払明細書金額明細通貨種類３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou3</td><td>（中継用）支払明細書明細備考３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou3</td><td>（中継用）支払明細書金額明細符号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi3</td><td>（中継用）支払明細書明細予備３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou4</td><td>（中継用）支払明細書摘要４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi4</td><td>（中継用）支払明細書金額明細４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu4</td><td>（中継用）支払明細書金額明細通貨種類４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou4</td><td>（中継用）支払明細書明細備考４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou4</td><td>（中継用）支払明細書金額明細符号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi4</td><td>（中継用）支払明細書明細予備４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou5</td><td>（中継用）支払明細書摘要５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi5</td><td>（中継用）支払明細書金額明細５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu5</td><td>（中継用）支払明細書金額明細通貨種類５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou5</td><td>（中継用）支払明細書明細備考５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou5</td><td>（中継用）支払明細書金額明細符号５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi5</td><td>（中継用）支払明細書明細予備５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou6</td><td>（中継用）支払明細書摘要６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi6</td><td>（中継用）支払明細書金額明細６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu6</td><td>（中継用）支払明細書金額明細通貨種類６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou6</td><td>（中継用）支払明細書明細備考６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou6</td><td>（中継用）支払明細書金額明細符号６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi6</td><td>（中継用）支払明細書明細予備６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou7</td><td>（中継用）支払明細書摘要７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi7</td><td>（中継用）支払明細書金額明細７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu7</td><td>（中継用）支払明細書金額明細通貨種類７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou7</td><td>（中継用）支払明細書明細備考７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou7</td><td>（中継用）支払明細書金額明細符号７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi7</td><td>（中継用）支払明細書明細予備７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou8</td><td>（中継用）支払明細書摘要８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi8</td><td>（中継用）支払明細書金額明細８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu8</td><td>（中継用）支払明細書金額明細通貨種類８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou8</td><td>（中継用）支払明細書明細備考８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou8</td><td>（中継用）支払明細書金額明細符号８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi8</td><td>（中継用）支払明細書明細予備８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou9</td><td>（中継用）支払明細書摘要９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi9</td><td>（中継用）支払明細書金額明細９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu9</td><td>（中継用）支払明細書金額明細通貨種類９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou9</td><td>（中継用）支払明細書明細備考９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou9</td><td>（中継用）支払明細書金額明細符号９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi9</td><td>（中継用）支払明細書明細予備９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou10</td><td>（中継用）支払明細書摘要１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi10</td><td>（中継用）支払明細書金額明細１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu10</td><td>（中継用）支払明細書金額明細通貨種類１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou10</td><td>（中継用）支払明細書明細備考１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou10</td><td>（中継用）支払明細書金額明細符号１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi10</td><td>（中継用）支払明細書明細予備１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou11</td><td>（中継用）支払明細書摘要１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi11</td><td>（中継用）支払明細書金額明細１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu11</td><td>（中継用）支払明細書金額明細通貨種類１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou11</td><td>（中継用）支払明細書明細備考１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou11</td><td>（中継用）支払明細書金額明細符号１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi11</td><td>（中継用）支払明細書明細予備１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou12</td><td>（中継用）支払明細書摘要１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi12</td><td>（中継用）支払明細書金額明細１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu12</td><td>（中継用）支払明細書金額明細通貨種類１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou12</td><td>（中継用）支払明細書明細備考１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou12</td><td>（中継用）支払明細書金額明細符号１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi12</td><td>（中継用）支払明細書明細予備１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou13</td><td>（中継用）支払明細書摘要１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi13</td><td>（中継用）支払明細書金額明細１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu13</td><td>（中継用）支払明細書金額明細通貨種類１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou13</td><td>（中継用）支払明細書明細備考１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou13</td><td>（中継用）支払明細書金額明細符号１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi13</td><td>（中継用）支払明細書明細予備１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou14</td><td>（中継用）支払明細書摘要１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi14</td><td>（中継用）支払明細書金額明細１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu14</td><td>（中継用）支払明細書金額明細通貨種類１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou14</td><td>（中継用）支払明細書明細備考１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou14</td><td>（中継用）支払明細書金額明細符号１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi14</td><td>（中継用）支払明細書明細予備１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou15</td><td>（中継用）支払明細書摘要１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi15</td><td>（中継用）支払明細書金額明細１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu15</td><td>（中継用）支払明細書金額明細通貨種類１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou15</td><td>（中継用）支払明細書明細備考１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou15</td><td>（中継用）支払明細書金額明細符号１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi15</td><td>（中継用）支払明細書明細予備１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou16</td><td>（中継用）支払明細書摘要１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi16</td><td>（中継用）支払明細書金額明細１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu16</td><td>（中継用）支払明細書金額明細通貨種類１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou16</td><td>（中継用）支払明細書明細備考１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou16</td><td>（中継用）支払明細書金額明細符号１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi16</td><td>（中継用）支払明細書明細予備１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou17</td><td>（中継用）支払明細書摘要１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi17</td><td>（中継用）支払明細書金額明細１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu17</td><td>（中継用）支払明細書金額明細通貨種類１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou17</td><td>（中継用）支払明細書明細備考１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou17</td><td>（中継用）支払明細書金額明細符号１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi17</td><td>（中継用）支払明細書明細予備１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou18</td><td>（中継用）支払明細書摘要１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi18</td><td>（中継用）支払明細書金額明細１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu18</td><td>（中継用）支払明細書金額明細通貨種類１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou18</td><td>（中継用）支払明細書明細備考１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou18</td><td>（中継用）支払明細書金額明細符号１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi18</td><td>（中継用）支払明細書明細予備１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou19</td><td>（中継用）支払明細書摘要１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi19</td><td>（中継用）支払明細書金額明細１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu19</td><td>（中継用）支払明細書金額明細通貨種類１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou19</td><td>（中継用）支払明細書明細備考１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou19</td><td>（中継用）支払明細書金額明細符号１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi19</td><td>（中継用）支払明細書明細予備１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou20</td><td>（中継用）支払明細書摘要２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi20</td><td>（中継用）支払明細書金額明細２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu20</td><td>（中継用）支払明細書金額明細通貨種類２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou20</td><td>（中継用）支払明細書明細備考２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou20</td><td>（中継用）支払明細書金額明細符号２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi20</td><td>（中継用）支払明細書明細予備２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou21</td><td>（中継用）支払明細書摘要２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi21</td><td>（中継用）支払明細書金額明細２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu21</td><td>（中継用）支払明細書金額明細通貨種類２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou21</td><td>（中継用）支払明細書明細備考２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou21</td><td>（中継用）支払明細書金額明細符号２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi21</td><td>（中継用）支払明細書明細予備２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou22</td><td>（中継用）支払明細書摘要２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi22</td><td>（中継用）支払明細書金額明細２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu22</td><td>（中継用）支払明細書金額明細通貨種類２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou22</td><td>（中継用）支払明細書明細備考２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou22</td><td>（中継用）支払明細書金額明細符号２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi22</td><td>（中継用）支払明細書明細予備２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou23</td><td>（中継用）支払明細書摘要２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi23</td><td>（中継用）支払明細書金額明細２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu23</td><td>（中継用）支払明細書金額明細通貨種類２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou23</td><td>（中継用）支払明細書明細備考２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou23</td><td>（中継用）支払明細書金額明細符号２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi23</td><td>（中継用）支払明細書明細予備２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou24</td><td>（中継用）支払明細書摘要２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi24</td><td>（中継用）支払明細書金額明細２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu24</td><td>（中継用）支払明細書金額明細通貨種類２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou24</td><td>（中継用）支払明細書明細備考２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou24</td><td>（中継用）支払明細書金額明細符号２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi24</td><td>（中継用）支払明細書明細予備２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisitekiyou25</td><td>（中継用）支払明細書摘要２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisi25</td><td>（中継用）支払明細書金額明細２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisituukasyu25</td><td>（中継用）支払明細書金額明細通貨種類２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibikou25</td><td>（中継用）支払明細書明細備考２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisikngkmisihugou25</td><td>（中継用）支払明細書金額明細符号２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaiyobi25</td><td>（中継用）支払明細書明細予備２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi1x1</td><td>（中継用）支払明細書明細部予備１－１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi1x2</td><td>（中継用）支払明細書明細部予備１－２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi1x3</td><td>（中継用）支払明細書明細部予備１－３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi1x4</td><td>（中継用）支払明細書明細部予備１－４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi1x5</td><td>（中継用）支払明細書明細部予備１－５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi1x6</td><td>（中継用）支払明細書明細部予備１－６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisisigoukeikingaku</td><td>（中継用）支払明細書支払合計金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisisigoukeituukasyu</td><td>（中継用）支払明細書支払合計通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi2</td><td>（中継用）支払明細書明細部予備２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisituutiranmidasi</td><td>（中継用）支払明細書通知欄見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg1</td><td>（中継用）支払明細書フリーメッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg2</td><td>（中継用）支払明細書フリーメッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg3</td><td>（中継用）支払明細書フリーメッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg4</td><td>（中継用）支払明細書フリーメッセージ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg5</td><td>（中継用）支払明細書フリーメッセージ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg6</td><td>（中継用）支払明細書フリーメッセージ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg7</td><td>（中継用）支払明細書フリーメッセージ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg8</td><td>（中継用）支払明細書フリーメッセージ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg9</td><td>（中継用）支払明細書フリーメッセージ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg10</td><td>（中継用）支払明細書フリーメッセージ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg11</td><td>（中継用）支払明細書フリーメッセージ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg12</td><td>（中継用）支払明細書フリーメッセージ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg13</td><td>（中継用）支払明細書フリーメッセージ１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg14</td><td>（中継用）支払明細書フリーメッセージ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg15</td><td>（中継用）支払明細書フリーメッセージ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg16</td><td>（中継用）支払明細書フリーメッセージ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg17</td><td>（中継用）支払明細書フリーメッセージ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg18</td><td>（中継用）支払明細書フリーメッセージ１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg19</td><td>（中継用）支払明細書フリーメッセージ１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg20</td><td>（中継用）支払明細書フリーメッセージ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg21</td><td>（中継用）支払明細書フリーメッセージ２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg22</td><td>（中継用）支払明細書フリーメッセージ２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg23</td><td>（中継用）支払明細書フリーメッセージ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg24</td><td>（中継用）支払明細書フリーメッセージ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg25</td><td>（中継用）支払明細書フリーメッセージ２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg26</td><td>（中継用）支払明細書フリーメッセージ２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg27</td><td>（中継用）支払明細書フリーメッセージ２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg28</td><td>（中継用）支払明細書フリーメッセージ２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg29</td><td>（中継用）支払明細書フリーメッセージ２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg30</td><td>（中継用）支払明細書フリーメッセージ３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg31</td><td>（中継用）支払明細書フリーメッセージ３１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg32</td><td>（中継用）支払明細書フリーメッセージ３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg33</td><td>（中継用）支払明細書フリーメッセージ３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg34</td><td>（中継用）支払明細書フリーメッセージ３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg35</td><td>（中継用）支払明細書フリーメッセージ３５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg36</td><td>（中継用）支払明細書フリーメッセージ３６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg37</td><td>（中継用）支払明細書フリーメッセージ３７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg38</td><td>（中継用）支払明細書フリーメッセージ３８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg39</td><td>（中継用）支払明細書フリーメッセージ３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg40</td><td>（中継用）支払明細書フリーメッセージ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg41</td><td>（中継用）支払明細書フリーメッセージ４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg42</td><td>（中継用）支払明細書フリーメッセージ４２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg43</td><td>（中継用）支払明細書フリーメッセージ４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg44</td><td>（中継用）支払明細書フリーメッセージ４４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg45</td><td>（中継用）支払明細書フリーメッセージ４５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisifreemsg46</td><td>（中継用）支払明細書フリーメッセージ４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon3x1</td><td>（中継用）支払明細書お知らせ文言３－１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisiosirasemongon3x2</td><td>（中継用）支払明細書お知らせ文言３－２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisisynykngk</td><td>（中継用）支払明細書収入金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisihtykeihi</td><td>（中継用）支払明細書必要経費</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykztkgk</td><td>（中継用）課税対象金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeitratkikbn</td><td>（中継用）税取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykhenkouumukbn</td><td>（中継用）契約者変更有無区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkykhtykeihi</td><td>（中継用）支払時契約者必要経費</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi3x1</td><td>（中継用）支払明細書明細部予備３－１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimisimeisaibuyobi3x2</td><td>（中継用）支払明細書明細部予備３－２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiShrdetailTy
 * @see     GenZT_SiShrdetailTy
 * @see     QZT_SiShrdetailTy
 * @see     GenQZT_SiShrdetailTy
 */
public class PKZT_SiShrdetailTy extends AbstractExDBPrimaryKey<ZT_SiShrdetailTy, PKZT_SiShrdetailTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SiShrdetailTy() {
    }

    public PKZT_SiShrdetailTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
        ztysikibetuno = pZtysikibetuno;
    }

    @Transient
    @Override
    public Class<ZT_SiShrdetailTy> getEntityClass() {
        return ZT_SiShrdetailTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztysikibetuno;

    public String getZtysikibetuno() {
        return ztysikibetuno;
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        ztysikibetuno = pZtysikibetuno;
    }

}